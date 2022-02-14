package cc.powind.workwx.base;

import cc.powind.workwx.core.JsonUtils;
import cc.powind.workwx.token.service.AccessTokenService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestOperations;

public class DefaultRestClient extends AbstractRestClient {

    private RestOperations restOperations;

    public DefaultRestClient(String host, AccessTokenService tokenService, RestOperations restOperations) {
        super(host, tokenService);
        this.restOperations = restOperations;
    }

    public RestOperations getRestOperations() {
        return restOperations;
    }

    public void setRestOperations(RestOperations restOperations) {
        this.restOperations = restOperations;
    }

    @Override
    protected <T> T readValue(String valueText, Class<T> responseType) {
        return JsonUtils.readValue(valueText, responseType);
    }

    @Override
    protected String doExecute(String httpMethod, String requestPath, Object param) {

        HttpMethod method = HttpMethod.resolve(httpMethod);
        if (method == null) {
            throw new IllegalArgumentException("http method " + httpMethod + "not found");
        }

        ResponseEntity<String> exchange = restOperations.exchange(requestPath, method, param == null ? null : new HttpEntity<>(param), String.class);

        return exchange.getBody();
    }
}
