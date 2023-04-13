package cc.powind.workwx.msg.model;

public class VideoMessage extends Message {

    private Video voice;

    public VideoMessage(String mediaId) {

        super(MsgTypeEnum.VIDEO.name().toLowerCase());

        this.voice = new Video(mediaId);
    }

    public Video getVoice() {
        return voice;
    }

    public void setVoice(Video voice) {
        this.voice = voice;
    }

    private static class Video {

        /**
         * 企业微信内部文件ID
         */
        private String mediaId;

        Video(String mediaId) {
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
