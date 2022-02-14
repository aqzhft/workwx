package cc.powind.workwx.address.service;

import cc.powind.workwx.address.model.User;
import cc.powind.workwx.address.model.UserResponse;
import cc.powind.workwx.app.AppEnum;
import cc.powind.workwx.core.RestClient;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class UserService {

    private RestClient restClient;

    public RestClient getRestClient() {
        return restClient;
    }

    public void setRestClient(RestClient restClient) {
        this.restClient = restClient;
    }

    public void insert(User model) {

        Map<String, String> errMsg = model.validate();
        if (!errMsg.isEmpty()) {
            throw new IllegalArgumentException(errMsg.toString());
        }

        restClient.post(AppEnum.ADDRESS.name(), "/cgi-bin/user/create", model);
    }

    public void update(User model) {

        Map<String, String> errMsg = model.validate();
        if (!errMsg.isEmpty()) {
            throw new IllegalArgumentException(errMsg.toString());
        }

        restClient.post(AppEnum.ADDRESS.name(), "/cgi-bin/user/update", model);
    }

    public void delete(String userId) {
        restClient.get(AppEnum.ADDRESS.name(), "/cgi-bin/user/delete?userid=" + userId);
    }

    public void delete(String[] userIds) {
        restClient.post(AppEnum.ADDRESS.name(), "/cgi-bin/user/batchdelete", Collections.singletonMap("useridlist", userIds));
    }

    public UserResponse find(String userId) {
        return restClient.get(AppEnum.ADDRESS.name(), "/cgi-bin/user/get?userid=" + userId, UserResponse.class);
    }

    public List<User> findByDeptId(Long deptId) {
        return findByDeptId(deptId, 0);
    }

    /**
     * 是否递归获取部门下所有人员
     * @param deptId 部门ID
     * @param fetchChild 是否递归：0否 1是
     * @return 所有人员信息
     */
    public List<User> findByDeptId(Long deptId, Integer fetchChild) {
        String requestPath = String.format("/cgi-bin/user/list?department_id=%s&fetch_child=%s", deptId, fetchChild);
        UserListResponse response = restClient.post(AppEnum.ADDRESS.name(), requestPath, null, UserListResponse.class);
        return response.getUserlist();
    }

    static class UserListResponse {

        private List<User> userlist;

        public List<User> getUserlist() {
            return userlist;
        }

        public void setUserlist(List<User> userlist) {
            this.userlist = userlist;
        }
    }
}
