package cc.powind.workwx.token.properties;

import cc.powind.workwx.token.exception.AppConfigIsNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class TokenProperties {

    /**
     * 企业ID
     */
    private String corpId;

    /**
     * 应用列表
     */
    private List<App> appList = new ArrayList<>();

    public String getCorpId() {
        return corpId;
    }

    public void setCorpId(String corpId) {
        this.corpId = corpId;
    }

    public List<App> getAppList() {
        return appList;
    }

    public void setAppList(List<App> appList) {
        this.appList = appList;
    }

    public App getByAgentCode(String agentCode) throws AppConfigIsNotFoundException {
        for (App app : appList) {
            if (agentCode != null && agentCode.equals(app.getAgentCode())) {
                return app;
            }
        }
        throw new AppConfigIsNotFoundException(agentCode);
    }

    public static class App {

        private Long agentId;

        private String agentCode;

        private String secret;

        public Long getAgentId() {
            return agentId;
        }

        public void setAgentId(Long agentId) {
            this.agentId = agentId;
        }

        public String getAgentCode() {
            return agentCode;
        }

        public void setAgentCode(String agentCode) {
            this.agentCode = agentCode;
        }

        public String getSecret() {
            return secret;
        }

        public void setSecret(String secret) {
            this.secret = secret;
        }
    }
}
