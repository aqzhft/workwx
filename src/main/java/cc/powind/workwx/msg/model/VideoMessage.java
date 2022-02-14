package cc.powind.workwx.msg.model;

/**
 * 视频 消息
 */
public class VideoMessage extends Message {

    // 消息体
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
