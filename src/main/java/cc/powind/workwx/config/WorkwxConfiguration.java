package cc.powind.workwx.config;

import cc.powind.workwx.core.RestClient;
import cc.powind.workwx.token.service.AccessTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class WorkwxConfiguration {

    @Autowired
    private WorkwxProperties properties;

    @Bean
    public AccessTokenService accessTokenService() {
        return null;
    }

    @Bean
    public RestClient restClient() {
        return null;
    }
}
