package cc.powind.workwx.config;

import cc.powind.workwx.address.service.WxUserService;
import cc.powind.workwx.base.DefaultRestClient;
import cc.powind.workwx.core.RestClient;
import cc.powind.workwx.msg.MessageService;
import cc.powind.workwx.token.service.AccessTokenServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

public class WorkwxConfiguration {

    @Autowired
    private WorkwxProperties properties;

    @Bean
    public RestClient restClient() {

        AccessTokenServiceImpl tokenService = new AccessTokenServiceImpl();
        tokenService.setProperties(properties.getToken());

        RestClient restClient = new DefaultRestClient(properties.getBase().getHost(), tokenService, new RestTemplate());
        tokenService.setRestClient(restClient);

        return restClient;
    }

    @Bean
    public MessageService messageService() {

        MessageService messageService = new MessageService();
        messageService.setRestClient(restClient());
        messageService.setProperties(properties.getToken());

        return messageService;
    }

    @Bean
    public WxUserService wxUserService() {
        WxUserService service = new WxUserService();
        service.setRestClient(restClient());
        service.setRootDeptId(properties.getBase().getRootDeptId());
        return service;
    }
}
