package cc.powind.workwx.exception;

public class RestException extends RuntimeException{

    public RestException(String message) {
        super(message == null ? "企业微信接口调用失败！" : message);
    }
}
