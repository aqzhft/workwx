package cc.powind.workwx.msg;

import cc.powind.workwx.app.AppEnum;
import cc.powind.workwx.base.DefaultRestClient;
import cc.powind.workwx.msg.model.MarkdownMessage;
import cc.powind.workwx.msg.model.TextMessage;
import cc.powind.workwx.msg.model.TextcardMessage;
import cc.powind.workwx.token.properties.TokenProperties;
import cc.powind.workwx.token.service.AccessTokenServiceImpl;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

public class MessageServiceTest {

    private static final MessageService messageService = new MessageService();

    static {

        String corpId = System.getenv("CORP_ID");
        String addressSecret = System.getenv("ASSISTANT_SECRET");

        AccessTokenServiceImpl tokenService = new AccessTokenServiceImpl();

        TokenProperties.App app = new TokenProperties.App();
        app.setAgentId(1000005L);
        app.setAgentCode(AppEnum.ASSISTANT.name());
        app.setSecret(addressSecret);

        TokenProperties properties = new TokenProperties();
        properties.setCorpId(corpId);
        properties.setAppList(Collections.singletonList(app));
        tokenService.setProperties(properties);

        tokenService.setRestClient(new DefaultRestClient("https://qyapi.weixin.qq.com", tokenService, new RestTemplate()));

        messageService.setProperties(properties);
        messageService.setRestClient(tokenService.getRestClient());
    }

    @Test
    public void sendTextMessage() {
        TextMessage message = new TextMessage("你好啊！world");
        message.setTouser("1");
        messageService.send(AppEnum.ASSISTANT.name(), message);
    }

    @Test
    public void sendTextCardMessage() {

        // 插件里显示的效果很差，按钮无法显示，但是可以跳转（凑合着用）

        TextcardMessage.Textcard textcard = new TextcardMessage.Textcard("检查通知", "JX120923", "http://www.baidu.com", "详情");
        TextcardMessage message = new TextcardMessage(textcard);
        message.setTouser("1");
        messageService.send(AppEnum.ASSISTANT.name(), message);
    }

    @Test
    public void sendMarkdownMessage() {

        // 只有企业微信可以用，插件不可用

        MarkdownMessage message = new MarkdownMessage("<font color=\"info\">广州TIT 1楼 301</font>");
        message.setTouser("1");
        messageService.send(AppEnum.ASSISTANT.name(), message);
    }
}
