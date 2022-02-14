package cc.powind.workwx.msg.model;

/**
 * markdown格式 消息
 */
public class MarkdownMessage extends Message {

    // 消息体
    private Markdown markdown;

    public MarkdownMessage(String content) {

        super(MsgTypeEnum.MARKDOWN.name().toLowerCase());

        this.markdown = new Markdown(content);
    }

    public Markdown getMarkdown() {
        return markdown;
    }

    public void setMarkdown(Markdown markdown) {
        this.markdown = markdown;
    }

    private static class Markdown {

        // 内容
        private String content;

        Markdown (String content) {
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
