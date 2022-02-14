package cc.powind.workwx.msg.model;

/**
 * 文件 消息
 */
public class FileMessage extends Message {

    public FileMessage(String mediaId) {

        super(MsgTypeEnum.FILE.name().toLowerCase());

        this.file = new File(mediaId);
    }

    // 消息体
    private File file;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    private static class File {

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
