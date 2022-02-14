package cc.powind.workwx.msg.model;

/**
 * 文本消息
 */
public class TextMessage extends Message {

    // 消息体
    private Text text;

    // 是否转义 1 是 0 否（默认）
    /**
     * 转义是指会将发送内容中的用户ID和部门ID转化为用户名和部门名称
     */
    private Integer enableIdTrans;

    public TextMessage(String content) {

        super(MsgTypeEnum.TEXT.name().toLowerCase());

        this.text = new Text(content);
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }

    public Integer getEnableIdTrans() {
        return enableIdTrans;
    }

    public void setEnableIdTrans(Integer enableIdTrans) {
        this.enableIdTrans = enableIdTrans;
    }

    /**
     * 消息体
     */
    private static class Text {

        private String content;

        Text(String content) {
            this.content = content;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}
