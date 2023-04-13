package cc.powind.workwx.address.service;

import cc.powind.workwx.address.model.WxUser;
import cc.powind.workwx.address.model.WxUserResponse;
import cc.powind.workwx.app.AppEnum;
import cc.powind.workwx.core.RestClient;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Collections;
import java.util.Map;

public class WxUserService {

    private RestClient restClient;

    private final static Long rootDeptId = 1L;

    public RestClient getRestClient() {
        return restClient;
    }

    public void setRestClient(RestClient restClient) {
        this.restClient = restClient;
    }

    public void insert(WxUser model) {

        model.setDepartment(ArrayUtils.isEmpty(model.getDepartment()) ? new Long[]{rootDeptId} : model.getDepartment());

        Map<String, String> errMsg = model.validate();
        if (!errMsg.isEmpty()) {
            throw new IllegalArgumentException(errMsg.toString());
        }

        restClient.post(AppEnum.ADDRESS.name(), "/cgi-bin/user/create", model);
    }

    public void update(WxUser model) {

        model.setDepartment(ArrayUtils.isEmpty(model.getDepartment()) ? new Long[]{rootDeptId} : model.getDepartment());

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

    public WxUserResponse find(String userId) {
        return restClient.get(AppEnum.ADDRESS.name(), "/cgi-bin/user/get?userid=" + userId, WxUserResponse.class);
    }
}
