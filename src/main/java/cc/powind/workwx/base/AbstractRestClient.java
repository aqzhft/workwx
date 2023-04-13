package cc.powind.workwx.base;

import cc.powind.workwx.core.BaseResponse;
import cc.powind.workwx.core.RestClient;
import cc.powind.workwx.exception.RestException;
import cc.powind.workwx.token.service.AccessTokenService;
import org.apache.commons.lang3.StringUtils;

public abstract class AbstractRestClient implements RestClient {

    private String host;

    private AccessTokenService tokenService;

    public AbstractRestClient(String host, AccessTokenService tokenService) {
        this.host = host;
        this.tokenService = tokenService;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public AccessTokenService getTokenService() {
        return tokenService;
    }

    public void setTokenService(AccessTokenService tokenService) {
        this.tokenService = tokenService;
    }

    public <T> T execute(String agentCode, String httpMethod, String path, Object param, Class<T> responseType) {

        // 增加token
        String requestPath = addToken(path, agentCode);

        // 结果处理
        String resultResponse = doExecute(httpMethod, host + requestPath, param);

        // 校验响应结果
        validateResponse(resultResponse);

        // 解析结果
        return responseType == null ? null : readValue(resultResponse, responseType);
    }

    @Override
    public <T> T get(String agentCode, String path, Class<T> responseType) {
        return execute(agentCode, "GET", path, null, responseType);
    }

    @Override
    public void get(String agentCode, String path) {
        execute(agentCode, "GET", path, null, null);
    }

    @Override
    public void post(String agentCode, String path, Object object) {
        execute(agentCode, "POST", path, object, null);
    }

    protected void validateResponse(String valueText) {

        BaseResponse baseResponse = readValue(valueText, BaseResponse.class);

        if (baseResponse == null) {
            throw new RestException("接口调用返回值为空");
        }

        baseResponse.validate();
    }

    protected abstract <T> T readValue(String valueText, Class<T> responseType);

    private String addToken(String path, String agentCode) {

        // 如果本身就是获取token的就不要再加了
        if (path.startsWith("/cgi-bin/gettoken")) {
            return path;
        }

        String token = tokenService.getToken(agentCode);

        if (StringUtils.contains(path, "?")) {
            return path + (path.endsWith("?") ? "" : "&") + "access_token=" + token;
        }

        else {
            return path + "?access_token=" + token;
        }
    }

    protected abstract String doExecute(String httpMethod, String requestPath, Object param);
}
