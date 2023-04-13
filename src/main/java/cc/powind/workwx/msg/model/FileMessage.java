package cc.powind.workwx.msg.model;

public class FileMessage extends Message {

    public FileMessage(String mediaId) {

        super(MsgTypeEnum.FILE.name().toLowerCase());

        this.file = new File(mediaId);
    }

    private File file;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    private static class File {

        /**
         * 企业微信内部的文件ID
         */
        private String mediaId;

        File(String mediaId) {
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
