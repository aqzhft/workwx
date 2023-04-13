package cc.powind.workwx.token.service;

import cc.powind.workwx.app.AppEnum;
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

        // get token from cache first, if there is no cache then call the remote api
        AccessToken token = tokenCache.computeIfAbsent(agentCode, this::getAccessTokenRemote);

        // also need to pay attention to whether the token is invalid
        if (token == null || token.isExpired()) {
            tokenCache.put(agentCode, getAccessTokenRemote(agentCode));
        }

        return tokenCache.get(agentCode).getAccessToken();
    }

    private AccessToken getAccessTokenRemote(String agentCode) {
        TokenProperties.App app = null;
        try {
            app = properties.getByAgentCode(agentCode);
            return getAccessTokenRemote(properties.getCorpId(), app.getSecret());
        } catch (AppConfigIsNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * call the remote api to get token
     * @param corpId corp id
     * @param corpSecret corp secret
     */
    private AccessToken getAccessTokenRemote(String corpId, String corpSecret) {
        return restClient.get(AppEnum.ADDRESS.name(), String.format("/cgi-bin/gettoken?corpid=%s&corpsecret=%s", corpId, corpSecret), AccessToken.class);
    }
}
