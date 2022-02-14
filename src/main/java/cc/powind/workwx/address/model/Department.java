package cc.powind.workwx.address.model;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 部门
 */
public class Department {

    /**
     * ID
     */
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 英文名称
     */
    private String nameEn;

    /**
     * 父部门ID
     */
    private Long parentid;

    /**
     * 次序值
     */
    private Integer order;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public Long getParentid() {
        return parentid;
    }

    public void setParentid(Long parentid) {
        this.parentid = parentid;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Map<String, String> validate() {

        Map<String, String> errs = new HashMap<>();

        if (id == null) {
            errs.put("id", "请指定部门的ID！");
        }

        if (StringUtils.isBlank(name)) {
            errs.put("name", "部门名称不能为空！");
        }

        if (name.length() > 32) {
            errs.put("nameLength", "部门名称长度过长！");
        }

        if (parentid == null) {
            errs.put("parentid", "父部门不能为空！");
        }

        return errs;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nameEn='" + nameEn + '\'' +
                ", parentid=" + parentid +
                ", order=" + order +
                '}';
    }
}
