package cc.powind.workwx.address;

import cc.powind.workwx.address.model.User;
import cc.powind.workwx.address.model.UserResponse;
import cc.powind.workwx.address.service.UserService;
import cc.powind.workwx.core.RestClient;
import cc.powind.workwx.token.TokenServiceTest;
import org.junit.Test;

import java.util.List;

public class UserServiceTest {

    private static final UserService service = new UserService();

    static {
        RestClient restClient = TokenServiceTest.getRestClient();
        service.setRestClient(restClient);
    }

    @Test
    public void insert() {

        User user = new User();
        user.setUserid("test2");
        user.setAlias("测试");
        user.setName("测试账号");
        user.setEmail("cesh2i@163.com");
        user.setDepartment(new Long[]{1L});

        service.insert(user);
    }

    @Test
    public void update() {

        User user = new User();
        user.setUserid("test");
        user.setAlias("测试1");
        user.setName("测试账号1");
        user.setEmail("ceshi1@163.com");
        user.setDepartment(new Long[]{1L});

        service.update(user);
    }

    @Test
    public void delete() {
        service.delete("test");
    }

    @Test
    public void deleteBatch() {
        service.delete(new String[]{"test", "test2"});
    }

    @Test
    public void find() {
        UserResponse user = service.find("test");
        System.out.println(user);
    }

    @Test
    public void findByDeptId() {
        List<User> userList = service.findByDeptId(1L);
        System.out.println(userList);
    }

    @Test
    public void findByDeptIdAndSubDept() {
        List<User> userList = service.findByDeptId(1L, 1);
        System.out.println(userList);
    }
}
