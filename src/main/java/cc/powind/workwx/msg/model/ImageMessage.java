package cc.powind.workwx.msg.model;

public class ImageMessage extends Message {

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

    private static class Image {

        /**
         * 企业微信内部的文件ID
         */
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
