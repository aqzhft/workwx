package cc.powind.workwx.msg;

import cc.powind.workwx.core.RestClient;
import cc.powind.workwx.msg.model.Message;
import cc.powind.workwx.token.exception.AppConfigIsNotFoundException;
import cc.powind.workwx.token.properties.TokenProperties;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Map;

import static cc.powind.workwx.core.JsonUtils.writeValueAsString;

public class MessageService {

    private final Log log = LogFactory.getLog(getClass());

    private RestClient restClient;

    private TokenProperties properties;

    public RestClient getRestClient() {
        return restClient;
    }

    public void setRestClient(RestClient restClient) {
        this.restClient = restClient;
    }

    public TokenProperties getProperties() {
        return properties;
    }

    public void setProperties(TokenProperties properties) {
        this.properties = properties;
    }

    public void send(String agentCode, Message message) {
        try {

            // 处理agentId
            TokenProperties.App app = properties.getByAgentCode(agentCode);
            message.setAgentid(app.getAgentId());

            // 校验下数据
            Map<String, String> validate = message.validate();
            if (!validate.isEmpty()) {
                throw new IllegalArgumentException(validate.toString());
            }

            String messageMsg = writeValueAsString(message);
            log.info("发送的消息内容：" + messageMsg);

            restClient.post(agentCode, "/cgi-bin/message/send", message);
        } catch (AppConfigIsNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /*private Charset getStringHttpMessageConverterCharset(List<HttpMessageConverter<?>> messageConverters) {

        if (charset == null) {
            // 如果为NULL，就去获取
            StringHttpMessageConverter converter = CollectionUtils.findValueOfType(messageConverters, StringHttpMessageConverter.class);
            charset = converter == null ? StandardCharsets.UTF_8 : converter.getDefaultCharset();
        }

        return charset;
    }*/
}
