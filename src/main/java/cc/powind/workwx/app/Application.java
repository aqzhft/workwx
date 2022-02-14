package cc.powind.workwx.app;

/**
 * 应用
 */
public class Application {

    // ID
    private Long agentId;

    // 密钥
    private String corpSecret;

    // 名称
    private String name;

    // 方形头像
    private String squareLogoUrl;

    // 应用详情
    private String description;

    // 是否停用
    private Integer close;

    // 可信域名
    private String redirectDomain;

    // 是否开启地理位置上报 0 - 不上报 1 - 上报
    private Integer reportLocationFlag;

    // 进入应用事件 0 - 不接收 1 - 接收
    private Integer isreportenter;

    // 应用主页地址
    private String homeUrl;
}
