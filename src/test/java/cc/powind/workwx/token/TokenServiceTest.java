package cc.powind.workwx.token;

import cc.powind.workwx.app.AppEnum;
import cc.powind.workwx.base.DefaultRestClient;
import cc.powind.workwx.core.RestClient;
import cc.powind.workwx.token.properties.TokenProperties;
import cc.powind.workwx.token.service.AccessTokenServiceImpl;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

public class TokenServiceTest {

    public static RestClient getRestClient() {
        String corpId = System.getenv("CORP_ID");
        String addressSecret = System.getenv("ADDRESS_SECRET");

        AccessTokenServiceImpl tokenService = new AccessTokenServiceImpl();

        TokenProperties.App app = new TokenProperties.App();
        app.setAgentId(10000L);
        app.setAgentCode(AppEnum.ADDRESS.name());
        app.setSecret(addressSecret);

        TokenProperties properties = new TokenProperties();
        properties.setCorpId(corpId);
        properties.setAppList(Collections.singletonList(app));
        tokenService.setProperties(properties);

        tokenService.setRestClient(new DefaultRestClient("https://qyapi.weixin.qq.com", tokenService, new RestTemplate()));

        return tokenService.getRestClient();
    }

    @Test
    public void getToken() {

        String corpId = System.getenv("CORP_ID");
        String addressSecret = System.getenv("ADDRESS_SECRET");

        AccessTokenServiceImpl tokenService = new AccessTokenServiceImpl();

        TokenProperties.App app = new TokenProperties.App();
        app.setAgentId(10000L);
        app.setAgentCode(AppEnum.ADDRESS.name());
        app.setSecret(addressSecret);

        TokenProperties properties = new TokenProperties();
        properties.setCorpId(corpId);
        properties.setAppList(Collections.singletonList(app));
        tokenService.setProperties(properties);

        tokenService.setRestClient(new DefaultRestClient("https://qyapi.weixin.qq.com", tokenService, new RestTemplate()));

        String token = tokenService.getToken(AppEnum.ADDRESS.name());
        System.out.println(token);
    }
}
