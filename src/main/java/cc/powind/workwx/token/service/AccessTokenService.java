package cc.powind.workwx.token.service;

/**
 * 令牌 接口服务
 */
public interface AccessTokenService {

    /**
     * 获取令牌
     * 注意：令牌有一定的过期时间，在过期时间范围内无需调用接口重新获取，从缓存中获取即可
     * @param agentCode 应用编号
     */
    String getToken(String agentCode);
}
