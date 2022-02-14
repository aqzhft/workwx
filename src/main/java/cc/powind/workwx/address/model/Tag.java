package cc.powind.workwx.address.model;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 标签
 */
public class Tag {

    /**
     * 标签ID
     */
    private Long tagid;

    /**
     * 标签名称
     */
    private String tagname;

    public Tag() {
    }

    public Tag(Long tagid, String tagname) {
        this.tagid = tagid;
        this.tagname = tagname;
    }

    public Long getTagid() {
        return tagid;
    }

    public void setTagid(Long tagid) {
        this.tagid = tagid;
    }

    public String getTagname() {
        return tagname;
    }

    public void setTagname(String tagname) {
        this.tagname = tagname;
    }

    public Map<String, String> validate() {

        Map<String, String> errMsg = new HashMap<>();

        if (tagid == null) {
            errMsg.put("tagid", "请指定标签的ID！");
        }

        if (StringUtils.isBlank(tagname)) {
            errMsg.put("tagname", "标签名称不能为空！");
        }

        if (tagname != null && tagname.length() > 32) {
            errMsg.put("tagname", "标签名称过长！");
        }

        return errMsg;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "tagid=" + tagid +
                ", tagname='" + tagname + '\'' +
                '}';
    }
}
