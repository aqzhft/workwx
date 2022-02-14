package cc.powind.workwx.core;

public class BaseProperties {

    /**
     * 接口地址
     */
    private String host = "https://qyapi.weixin.qq.com";

    /**
     * 部门根节点
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
