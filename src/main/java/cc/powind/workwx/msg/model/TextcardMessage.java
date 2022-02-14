package cc.powind.workwx.msg.model;

/**
 * 文本卡片 消息
 */
public class TextcardMessage extends Message {

    // 消息体
    private Textcard textcard;

    public TextcardMessage(Textcard textcard) {

        super(MsgTypeEnum.TEXTCARD.name().toLowerCase());

        this.textcard = textcard;
    }

    public Textcard getTextcard() {
        return textcard;
    }

    public void setTextcard(Textcard textcard) {
        this.textcard = textcard;
    }

    public static class Textcard {

        // 标题
        private String title;

        // 描述
        private String description;

        // 跳转的地址
        private String url;

        // 按钮文字 默认为【详情】不能超过4个
        private String btntxt;

        public Textcard(String title, String description, String url) {
            this.title = title;
            this.description = description;
            this.url = url;
        }

        public Textcard(String title, String description, String url, String btntxt) {
            this.title = title;
            this.description = description;
            this.url = url;
            this.btntxt = btntxt;
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

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getBtntxt() {
            return btntxt;
        }

        public void setBtntxt(String btntxt) {
            this.btntxt = btntxt;
        }
    }
}
