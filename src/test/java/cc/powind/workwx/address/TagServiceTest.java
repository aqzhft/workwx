package cc.powind.workwx.address;

import cc.powind.workwx.address.model.Tag;
import cc.powind.workwx.address.service.TagService;
import cc.powind.workwx.core.RestClient;
import cc.powind.workwx.token.TokenServiceTest;
import org.junit.Test;

import java.util.List;

public class TagServiceTest {

    private static final TagService service = new TagService();

    static {
        RestClient restClient = TokenServiceTest.getRestClient();
        service.setRestClient(restClient);
    }

    @Test
    public void insert() {

        Tag tag = new Tag();
        tag.setTagid(100L);
        tag.setTagname("测试标签");

        service.insert(tag);
    }

    @Test
    public void update() {

        Tag tag = new Tag();
        tag.setTagid(100L);
        tag.setTagname("测试标签test");

        service.update(tag);
    }

    @Test
    public void findAll() {
        List<Tag> tagList = service.findAll();
        System.out.println(tagList);
    }

    @Test
    public void delete() {
        service.delete(100L);
    }

    @Test
    public void addTagToUserList() {
        service.addUserList(100L, new String[]{"2"});
    }

    @Test
    public void addTagToDeptList() {
        service.addUserList(100L, new Long[]{1L});
    }

    @Test
    public void deleteTagFromUserList() {
        service.deleteUserList(100L, new String[]{"2"});
    }

    @Test
    public void deleteTagFromDeptList() {
        service.deleteUserList(100L, new Long[]{1L});
    }
}
