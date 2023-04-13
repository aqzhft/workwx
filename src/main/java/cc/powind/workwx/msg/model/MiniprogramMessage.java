package cc.powind.workwx.msg.model;

import java.util.List;

public class MiniprogramMessage extends Message {

    private MiniprogramNotice miniprogramNotice;

    public MiniprogramMessage(MiniprogramNotice miniprogramNotice) {
        super(MsgTypeEnum.MINIPROGRAM_NOTICE.name().toLowerCase());
        this.miniprogramNotice = miniprogramNotice;
    }

    public MiniprogramNotice getMiniprogramNotice() {
        return miniprogramNotice;
    }

    public void setMiniprogramNotice(MiniprogramNotice miniprogramNotice) {
        this.miniprogramNotice = miniprogramNotice;
    }

    public static class MiniprogramNotice {

        // 小程序的ID
        private String appid;

        // 跳转页面
        private String page;

        private String title;

        private String description;

        // 是否放大第一个contentItem
        private Boolean emphasisFirstItem;

        // 消息内容键值 最多允许10个
        private List<ContentItem> contentItem;

        public String getAppid() {
            return appid;
        }

        public void setAppid(String appid) {
            this.appid = appid;
        }

        public String getPage() {
            return page;
        }

        public void setPage(String page) {
            this.page = page;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Boolean getEmphasisFirstItem() {
            return emphasisFirstItem;
        }

        public void setEmphasisFirstItem(Boolean emphasisFirstItem) {
            this.emphasisFirstItem = emphasisFirstItem;
        }

        public List<ContentItem> getContentItem() {
            return contentItem;
        }

        public void setContentItem(List<ContentItem> contentItem) {
            this.contentItem = contentItem;
        }
    }

    public static class ContentItem {

        private String key;

        private String value;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
