package cc.powind.workwx.msg.model;

public class VoiceMessage extends Message {

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

        /**
         * 企业微信内部文件ID
         */
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
