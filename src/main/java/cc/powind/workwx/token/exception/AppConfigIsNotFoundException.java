package cc.powind.workwx.token.exception;

public class AppConfigIsNotFoundException extends Exception {

    public AppConfigIsNotFoundException(String agentCode) {
        super("应用标识为【" + agentCode + "】配置信息未查询到！");
    }
}
