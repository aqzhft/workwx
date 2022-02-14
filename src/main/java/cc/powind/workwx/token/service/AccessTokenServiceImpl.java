package cc.powind.workwx.token.service;

import cc.powind.workwx.app.AppEnum;
import cc.powind.workwx.core.RequestMappings;
import cc.powind.workwx.core.RestClient;
import cc.powind.workwx.token.exception.AppConfigIsNotFoundException;
import cc.powind.workwx.token.model.AccessToken;
import cc.powind.workwx.token.properties.TokenProperties;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AccessTokenServiceImpl implements AccessTokenService {

    private final Map<String, AccessToken> tokenCache = new ConcurrentHashMap<>();

    private TokenProperties properties;

    private RestClient restClient;

    public TokenProperties getProperties() {
        return properties;
    }

    public void setProperties(TokenProperties properties) {
        this.properties = properties;
    }

    public RestClient getRestClient() {
        return restClient;
    }

    public void setRestClient(RestClient restClient) {
        this.restClient = restClient;
    }

    @Override
    public String getToken(String agentCode) {

        // 从缓存中获取，如果缓存中有直接返回，没有则请求接口并缓存

        AccessToken accessToken = tokenCache.get(agentCode);
        if (accessToken != null && !accessToken.isExpired()) {
            return accessToken.getAccessToken();
        }

        // todo 此处需要优化

        synchronized (this) {
            try {
                TokenProperties.App app = properties.getByAgentCode(agentCode);
                AccessToken token = getAccessTokenFromRemote(properties.getCorpId(), app.getSecret());
                tokenCache.put(agentCode, token);
                return token.getAccessToken();
            } catch (AppConfigIsNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * 通过调用远程API获取令牌
     * @param corpId 企业ID
     * @param corpSecret 密钥
     */
    private AccessToken getAccessTokenFromRemote(String corpId, String corpSecret) {
        return restClient.get(AppEnum.ADDRESS.name(), String.format(RequestMappings.TOKEN.GET_ACCESS_TOKEN.getValue(), corpId, corpSecret), AccessToken.class);
    }
}
