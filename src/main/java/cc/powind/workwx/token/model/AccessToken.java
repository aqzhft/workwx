package cc.powind.workwx.token.model;

import java.time.Instant;

public class AccessToken {

    /**
     * token value
     */
    private String accessToken;

    /**
     * when create the token
     */
    private Instant createTime;

    /**
     * expire time, the unit is second
     */
    private long expiresIn = 0;

    public AccessToken() {
        this.createTime = Instant.now();
    }

    public boolean isExpired() {

        // time may be off, require early handle
        return createTime.plusSeconds(expiresIn - 30).isBefore(Instant.now());
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
