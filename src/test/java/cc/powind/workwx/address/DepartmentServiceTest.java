package cc.powind.workwx.address;

import cc.powind.workwx.address.model.Department;
import cc.powind.workwx.address.service.DepartmentService;
import cc.powind.workwx.core.RestClient;
import cc.powind.workwx.token.TokenServiceTest;
import org.junit.Test;

import java.util.List;

public class DepartmentServiceTest {

    private static final DepartmentService service = new DepartmentService();

    static {
        RestClient restClient = TokenServiceTest.getRestClient();
        service.setRestClient(restClient);
        service.setRootDeptId(1L);
    }

    @Test
    public void insert() {

        Department department = new Department();
        department.setId(2L);
        department.setParentid(1L);
        department.setName("测试部门");

        service.insert(department);
    }

    @Test
    public void update() {

        Department department = new Department();
        department.setId(2L);
        department.setParentid(1L);
        department.setName("测试部门2");

        service.update(department);
    }

    @Test
    public void find() {
        Department department = service.findByDeptId(2L);
        System.out.println(department);
    }

    @Test
    public void findAll() {
        List<Department> departmentList = service.findAll();
        System.out.println(departmentList);
    }

    @Test
    public void delete() {
        service.delete(2L);
    }
}
