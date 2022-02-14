package cc.powind.workwx.msg.model;

import java.util.List;

/**
 * 图文 消息
 * 图片用的是企业微信自己素材（就这个区别）
 */
public class MpnewsMessage extends Message {

    // 消息体
    private Mpnews mpnews;

    // 是否转义 1 是 0 否（默认）
    /**
     * 转义是指会将发送内容中的用户ID和部门ID转化为用户名和部门名称
     */
    private Integer enableIdTrans;

    public MpnewsMessage(List<Article> articles) {

        super(MsgTypeEnum.MPNEWS.name().toLowerCase());

        this.mpnews = new Mpnews(articles);
    }

    public Mpnews getMpnews() {
        return mpnews;
    }

    public void setMpnews(Mpnews mpnews) {
        this.mpnews = mpnews;
    }

    public Integer getEnableIdTrans() {
        return enableIdTrans;
    }

    public void setEnableIdTrans(Integer enableIdTrans) {
        this.enableIdTrans = enableIdTrans;
    }

    private static class Mpnews {

        private List<Article> articles;

        Mpnews(List<Article> articles) {
            this.articles = articles;
        }

        public List<Article> getArticles() {
            return articles;
        }

        public void setArticles(List<Article> articles) {
            this.articles = articles;
        }
    }

    public static class Article {

        // 标题
        private String title;

        // 图片
        private String thumbMediaId;

        // 作者
        private String author;

        // 跳转的连接
        private String contentSourceUrl;

        // 内容
        private String content;

        // 描述
        private String digest;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getThumbMediaId() {
            return thumbMediaId;
        }

        public void setThumbMediaId(String thumbMediaId) {
            this.thumbMediaId = thumbMediaId;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getContentSourceUrl() {
            return contentSourceUrl;
        }

        public void setContentSourceUrl(String contentSourceUrl) {
            this.contentSourceUrl = contentSourceUrl;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getDigest() {
            return digest;
        }

        public void setDigest(String digest) {
            this.digest = digest;
        }
    }
}
