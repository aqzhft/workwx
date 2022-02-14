package cc.powind.workwx.address.service;

import cc.powind.workwx.address.model.Tag;
import cc.powind.workwx.app.AppEnum;
import cc.powind.workwx.core.RestClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TagService {

    private RestClient restClient;

    public RestClient getRestClient() {
        return restClient;
    }

    public void setRestClient(RestClient restClient) {
        this.restClient = restClient;
    }

    public void insert(Tag model) {

        Map<String, String> errMsg = model.validate();
        if (!errMsg.isEmpty()) {
            throw new IllegalArgumentException(errMsg.toString());
        }

        restClient.post(AppEnum.ADDRESS.name(), "/cgi-bin/tag/create", model);
    }

    public void update(Tag model) {

        Map<String, String> errMsg = model.validate();
        if (!errMsg.isEmpty()) {
            throw new IllegalArgumentException(errMsg.toString());
        }

        restClient.post(AppEnum.ADDRESS.name(), "/cgi-bin/tag/update", model);
    }

    public void delete(Long tagid) {
        restClient.get(AppEnum.ADDRESS.name(), "/cgi-bin/tag/delete?tagid=" + tagid);
    }

    public List<Tag> findAll() {
        TagListResponse response = restClient.get(AppEnum.ADDRESS.name(), "/cgi-bin/tag/list", TagListResponse.class);
        return response.getTaglist();
    }

    public void addUserList(Long tagid, String[] userids) {

        Map<String, Object> param = new HashMap<>();
        param.put("tagid", tagid);
        param.put("userlist", userids);

        restClient.post(AppEnum.ADDRESS.name(), "/cgi-bin/tag/addtagusers", param);
    }

    public void addUserList(Long tagId, Long[] deptIds) {

        Map<String, Object> param = new HashMap<>();
        param.put("tagid", tagId);
        param.put("partylist", deptIds);

        restClient.post(AppEnum.ADDRESS.name(), "/cgi-bin/tag/addtagusers", param);
    }

    public void deleteUserList(Long tagId, String[] userIds) {

        Map<String, Object> param = new HashMap<>();
        param.put("tagid", tagId);
        param.put("userlist", userIds);

        restClient.post(AppEnum.ADDRESS.name(), "/cgi-bin/tag/deltagusers", param);
    }

    public void deleteUserList(Long tagId, Long[] deptIds) {

        Map<String, Object> param = new HashMap<>();
        param.put("tagid", tagId);
        param.put("partylist", deptIds);

        restClient.post(AppEnum.ADDRESS.name(), "/cgi-bin/tag/deltagusers", param);
    }

    static class TagListResponse {

        private List<Tag> taglist;

        public List<Tag> getTaglist() {
            return taglist;
        }

        public void setTaglist(List<Tag> taglist) {
            this.taglist = taglist;
        }
    }
}
