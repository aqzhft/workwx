package cc.powind.workwx.msg.model;

/**
 * 语音 消息
 */
public class VoiceMessage extends Message {

    // 消息体
    private Voice voice;

    public VoiceMessage(String mediaId) {

        super(MsgTypeEnum.VOICE.name().toLowerCase());

        this.voice = new Voice(mediaId);
    }

    public Voice getVoice() {
        return voice;
    }

    public void setVoice(Voice voice) {
        this.voice = voice;
    }

    private static class Voice {

        private String mediaId;

        Voice(String mediaId) {
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
