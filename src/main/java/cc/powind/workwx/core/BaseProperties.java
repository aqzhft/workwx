package cc.powind.workwx.core;

public class BaseProperties {

    /**
     * weixin remote server address
     */
    private String host = "https://qyapi.weixin.qq.com";

    /**
     * root dept id
     * everyone in the weixin need a dept id
     */
    private Long rootDeptId = 1L;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Long getRootDeptId() {
        return rootDeptId;
    }

    public void setRootDeptId(Long rootDeptId) {
        this.rootDeptId = rootDeptId;
    }
}
