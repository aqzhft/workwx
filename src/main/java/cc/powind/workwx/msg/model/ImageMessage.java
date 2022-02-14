package cc.powind.workwx.msg.model;

/**
 * 图片消息
 */
public class ImageMessage extends Message {

    // 消息体
    private Image image;

    public ImageMessage(String mediaId) {

        super(MsgTypeEnum.IMAGE.name().toLowerCase());

        this.image = new Image(mediaId);
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    /**
     * 消息体
     */
    private static class Image {

        private String mediaId;

        Image (String mediaId) {
            this.mediaId = mediaId;
        }

        public String getMediaId() {
            return mediaId;
        }

        public void setMediaId(String mediaId) {
            this.mediaId = mediaId;
        }
    }
}
