package cc.powind.workwx.address.service;

import cc.powind.workwx.address.model.Department;
import cc.powind.workwx.app.AppEnum;
import cc.powind.workwx.core.RestClient;

import java.util.List;

public class DepartmentService {

    private RestClient restClient;

    /**
     * 顶级部门的ID
     */
    private Long rootDeptId;

    public RestClient getRestClient() {
        return restClient;
    }

    public void setRestClient(RestClient restClient) {
        this.restClient = restClient;
    }

    public Long getRootDeptId() {
        return rootDeptId;
    }

    public void setRootDeptId(Long rootDeptId) {
        this.rootDeptId = rootDeptId;
    }

    public void insert(Department model) {

        // 父部门为空就默认填写一个
        if (model.getParentid() == null) {
            model.setParentid(rootDeptId);
        }

        // 部门ID不能是根部门ID
        if (model.getId() != null && model.getId().equals(rootDeptId)) {
            throw new IllegalArgumentException("部门ID不能是根部门ID！");
        }

        restClient.post(AppEnum.ADDRESS.name(), "/cgi-bin/department/create", model);
    }

    public void update(Department model) {

        // 父部门为空就默认填写一个
        if (model.getParentid() == null) {
            model.setParentid(rootDeptId);
        }

        // 部门ID不能是根部门ID
        if (model.getId() != null && model.getId().equals(rootDeptId)) {
            throw new IllegalArgumentException("部门ID不能是根部门ID！");
        }

        restClient.post(AppEnum.ADDRESS.name(), "/cgi-bin/department/update", model);
    }

    public void delete(Long id) {
        restClient.get(AppEnum.ADDRESS.name(), "/cgi-bin/department/delete?id=" + id);
    }

    public List<Department> findAll() {
        DepartmentListResponse response = restClient.get(AppEnum.ADDRESS.name(), "/cgi-bin/department/list", DepartmentListResponse.class);
        return response.getDepartment();
    }

    public Department findByDeptId(Long deptId) {
        DepartmentResponse response = restClient.get(AppEnum.ADDRESS.name(), "/cgi-bin/department/get?id=" + deptId, DepartmentResponse.class);
        return response.getDepartment();
    }

    static class DepartmentListResponse {

        private List<Department> department;

        public List<Department> getDepartment() {
            return department;
        }

        public void setDepartment(List<Department> department) {
            this.department = department;
        }
    }

    static class DepartmentResponse {

        private Department department;

        public Department getDepartment() {
            return department;
        }

        public void setDepartment(Department department) {
            this.department = department;
        }
    }
}
