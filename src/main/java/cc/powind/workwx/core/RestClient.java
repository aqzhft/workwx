package cc.powind.workwx.core;

public interface RestClient {

    <T> T get(String agentCode, String path, Class<T> responseType);

    void get(String agentCode, String path);

    void post(String agentCode, String path, Object object);
}
