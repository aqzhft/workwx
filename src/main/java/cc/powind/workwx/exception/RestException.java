package cc.powind.workwx.exception;

public class RestException extends RuntimeException{

    public RestException(String message) {
        super(message == null ? "call weixin remote api error" : message);
    }
}
