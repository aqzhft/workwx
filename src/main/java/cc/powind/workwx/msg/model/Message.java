package cc.powind.workwx.msg.model;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

public abstract class Message {

    /**
     * 接收人
     */
    private String touser;

    /**
     * 消息类型
     */
    private String msgtype;

    /**
     * 应用编号
     */
    private Long agentid;

    /**
     * 是否加密 1 是 0 否（默认）
     */
    private Integer safe;

    /**
     * 是否进行重复性检查 1 是 0 否（默认）
     */
    private Integer enableDuplicateCheck;

    /**
     * 重复性检查的间隔时间（秒）最大不超过4个小时
     */
    private Integer duplicateCheckInterval;

    public Message() {}

    public Message(String msgtype) {
        this.msgtype = msgtype;
    }

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    public Long getAgentid() {
        return agentid;
    }

    public void setAgentid(Long agentid) {
        this.agentid = agentid;
    }

    public Integer getSafe() {
        return safe;
    }

    public void setSafe(Integer safe) {
        this.safe = safe;
    }

    public Integer getEnableDuplicateCheck() {
        return enableDuplicateCheck;
    }

    public void setEnableDuplicateCheck(Integer enableDuplicateCheck) {
        this.enableDuplicateCheck = enableDuplicateCheck;
    }

    public Integer getDuplicateCheckInterval() {
        return duplicateCheckInterval;
    }

    public void setDuplicateCheckInterval(Integer duplicateCheckInterval) {
        this.duplicateCheckInterval = duplicateCheckInterval;
    }

    public Map<String, String> validate() {

        Map<String, String> errs = new HashMap<>();

        if (agentid == null) {
            errs.put("agentid", "应用ID不能为空");
        }

        if (StringUtils.isBlank(msgtype)) {
            errs.put("msgtype", "消息类型不能为空");
        }

        if (StringUtils.isBlank(touser)) {
            errs.put("to", "接收人不能为空");
        }

        return errs;
    }
}
