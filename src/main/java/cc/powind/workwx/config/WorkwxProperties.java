package cc.powind.workwx.config;

import cc.powind.workwx.core.BaseProperties;
import cc.powind.workwx.token.properties.TokenProperties;

public class WorkwxProperties {

    private BaseProperties base = new BaseProperties();

    private TokenProperties token = new TokenProperties();

    public BaseProperties getBase() {
        return base;
    }

    public void setBase(BaseProperties base) {
        this.base = base;
    }

    public TokenProperties getToken() {
        return token;
    }

    public void setToken(TokenProperties token) {
        this.token = token;
    }
}
