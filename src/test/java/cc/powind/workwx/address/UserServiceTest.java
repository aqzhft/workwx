package cc.powind.workwx.address;

import cc.powind.workwx.address.model.WxUser;
import cc.powind.workwx.address.model.WxUserResponse;
import cc.powind.workwx.address.service.WxUserService;
import cc.powind.workwx.core.RestClient;
import cc.powind.workwx.token.TokenServiceTest;
import org.junit.Test;

public class UserServiceTest {

    private static final WxUserService service = new WxUserService();

    static {
        RestClient restClient = TokenServiceTest.getRestClient();
        service.setRestClient(restClient);
    }

    @Test
    public void insert() {

        WxUser user = new WxUser();
        user.setUserid("test2");
        user.setAlias("测试");
        user.setName("测试账号");
        user.setEmail("cesh2i@163.com");
        user.setDepartment(new Long[]{1L});

        service.insert(user);
    }

    @Test
    public void update() {

        WxUser user = new WxUser();
        user.setUserid("test");
        user.setAlias("测试1");
        user.setName("测试账号1");
        user.setEmail("ceshi1@163.com");
        user.setDepartment(new Long[]{1L});

        service.update(user);
    }

    @Test
    public void delete() {
        service.delete("2");
    }

    @Test
    public void deleteBatch() {
        service.delete(new String[]{"test", "test2"});
    }

    @Test
    public void find() {
        WxUserResponse user = service.find("test");
        System.out.println(user);
    }
}
