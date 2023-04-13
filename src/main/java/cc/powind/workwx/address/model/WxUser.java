package cc.powind.workwx.address.model;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WxUser {

    /**
     * unique id
     */
    private String userid;

    private String name;

    /**
     * nickname
     */
    private String alias;

    private String mobile;

    private Long[] department;

    /**
     * department order
     */
    private Long[] order;

    private String position;

    /**
     * gender 1 male 2 female
     */
    private Integer gender;

    private String email;

    /**
     * telephone
     */
    private String telephone;

    /**
     * 是否是部门领导
     */
    private Long[] isLeaderInDept;

    /**
     * avatar
     */
    private String avatarMediaid;

    private Integer enable;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Long[] getDepartment() {
        return department;
    }

    public void setDepartment(Long[] department) {
        this.department = department;
    }

    public Long[] getOrder() {
        return order;
    }

    public void setOrder(Long[] order) {
        this.order = order;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Long[] getIsLeaderInDept() {
        return isLeaderInDept;
    }

    public void setIsLeaderInDept(Long[] isLeaderInDept) {
        this.isLeaderInDept = isLeaderInDept;
    }

    public String getAvatarMediaid() {
        return avatarMediaid;
    }

    public void setAvatarMediaid(String avatarMediaid) {
        this.avatarMediaid = avatarMediaid;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public Map<String, String> validate() {

        Map<String, String> errs = new HashMap<>();

        if (StringUtils.isBlank(userid)) {
            errs.put("userid", "用户编号不能为空");
        }

        if (userid != null && userid.length() > 64) {
            errs.put("useridLength", "用户编号长度过长");
        }

        if (StringUtils.isBlank(name)) {
            errs.put("name", "用户名称不能为空");
        }

        if (name != null && name.length() > 64) {
            errs.put("nameLength", "用户名称长度过长");
        }

        if (ArrayUtils.isEmpty(department)) {
            errs.put("department", "用户所属部门不能为空");
        }

        if (StringUtils.isBlank(mobile) && StringUtils.isBlank(email)) {
            errs.put("mobileEmail", "手机号和邮箱地址不能同时为空");
        }

        return errs;
    }

    @Override
    public String toString() {
        return "User{" + "userid='" + userid + '\'' + ", name='" + name + '\'' + ", alias='" + alias + '\'' + ", mobile='" + mobile + '\'' +
                ", department=" + Arrays.toString(department) + ", order=" + Arrays.toString(order) + ", position='" + position + '\'' + ", gender=" + gender + ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' + ", isLeaderInDept=" + Arrays.toString(isLeaderInDept) + ", avatarMediaid='" + avatarMediaid + '\'' + ", enable=" + enable + '}';
    }
}
