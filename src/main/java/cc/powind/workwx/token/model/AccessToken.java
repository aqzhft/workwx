package cc.powind.workwx.token.model;

import java.time.Instant;

/**
 * 令牌
 */
public class AccessToken {

    /**
     * 令牌
     */
    private String accessToken;

    /**
     * 创建时间
     */
    private Instant createTime;

    /**
     * 过期时间
     */
    private long expiresIn = 0;

    public AccessToken() {
        this.createTime = Instant.now();
    }

    public boolean isExpired() {

        // 时间可能有偏差，提前一分钟
        return createTime.plusSeconds(expiresIn - 60).isBefore(Instant.now());
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Instant getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Instant createTime) {
        this.createTime = createTime;
    }

    public long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
    }
}
