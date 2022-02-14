package cc.powind.workwx.msg.model;

import java.util.List;

/**
 * 图文 消息
 */
public class NewsMessage extends Message {

    // 消息体
    private News news;

    public NewsMessage(List<Article> articles) {

        super(MsgTypeEnum.NEWS.name().toLowerCase());

        this.news = new News(articles);
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    private static class News {

        private List<Article> articles;

        News (List<Article> articles) {
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

        // 描述
        private String description;

        // 跳转的地址
        private String url;

        // 图片地址
        private String picurl;

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

        public String getPicurl() {
            return picurl;
        }

        public void setPicurl(String picurl) {
            this.picurl = picurl;
        }
    }
}
