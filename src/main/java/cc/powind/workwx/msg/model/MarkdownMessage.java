package cc.powind.workwx.msg.model;

public class MarkdownMessage extends Message {

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
