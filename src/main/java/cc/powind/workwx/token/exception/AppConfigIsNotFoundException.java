package cc.powind.workwx.token.exception;

public class AppConfigIsNotFoundException extends Exception {

    public AppConfigIsNotFoundException(String agentCode) {
        super("app [ " + agentCode + " ] config not found");
    }
    
}
