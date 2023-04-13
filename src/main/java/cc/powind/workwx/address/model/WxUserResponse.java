package cc.powind.workwx.address.model;

import java.util.Arrays;

public class WxUserResponse {

    /**
     * unique id
     */
    private String userid;

    /**
     * name
     */
    private String name;

    /**
     * mobile phone
     */
    private String mobile;

    /**
     * 部门
     */
    private Long[] department;

    /**
     * 部门内的排序
     */
    private Long[] order;

    /**
     * 职务信息
     */
    private String position;

    /**
     * gender：0 not defined 1 male 2 female
     */
    private String gender;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 企业邮箱
     */
    private String bizMail;

    /**
     * 所在部门内是否是部门负责人
     */
    private Long[] isLeaderInDept;

    /**
     * 直属领导是谁
     */
    private String[] directLeader;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 头像缩略图
     */
    private String thumbAvatar;

    /**
     * 联系电话
     */
    private String telephone;

    /**
     * 昵称
     */
    private String alias;

    /**
     * 状态 1=已激活，2=已禁用，4=未激活，5=退出企业
     */
    private Integer status;

    /**
     * 员工个人二维码
     */
    private String qrCode;

    /**
     * 地址
     */
    private String address;

    /**
     * open userid
     */
    private String openUserid;

    /**
     * 主部门
     */
    private Integer mainDepartment;

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBizMail() {
        return bizMail;
    }

    public void setBizMail(String bizMail) {
        this.bizMail = bizMail;
    }

    public Long[] getIsLeaderInDept() {
        return isLeaderInDept;
    }

    public void setIsLeaderInDept(Long[] isLeaderInDept) {
        this.isLeaderInDept = isLeaderInDept;
    }

    public String[] getDirectLeader() {
        return directLeader;
    }

    public void setDirectLeader(String[] directLeader) {
        this.directLeader = directLeader;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getThumbAvatar() {
        return thumbAvatar;
    }

    public void setThumbAvatar(String thumbAvatar) {
        this.thumbAvatar = thumbAvatar;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOpenUserid() {
        return openUserid;
    }

    public void setOpenUserid(String openUserid) {
        this.openUserid = openUserid;
    }

    public Integer getMainDepartment() {
        return mainDepartment;
    }

    public void setMainDepartment(Integer mainDepartment) {
        this.mainDepartment = mainDepartment;
    }

    @Override
    public String toString() {
        return "UserResponse{" +
                "userid='" + userid + '\'' +
                ", name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", department=" + Arrays.toString(department) +
                ", order=" + Arrays.toString(order) +
                ", position='" + position + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", bizMail='" + bizMail + '\'' +
                ", isLeaderInDept=" + Arrays.toString(isLeaderInDept) +
                ", directLeader=" + Arrays.toString(directLeader) +
                ", avatar='" + avatar + '\'' +
                ", thumbAvatar='" + thumbAvatar + '\'' +
                ", telephone='" + telephone + '\'' +
                ", alias='" + alias + '\'' +
                ", status=" + status +
                ", qrCode='" + qrCode + '\'' +
                ", address='" + address + '\'' +
                ", openUserid='" + openUserid + '\'' +
                ", mainDepartment='" + mainDepartment + '\'' +
                '}';
    }
}
