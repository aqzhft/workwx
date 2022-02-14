package cc.powind.workwx.msg.model;

import java.util.List;

/**
 * 任务卡片 消息
 */
public class TaskcardMessage extends Message {

    // 消息体
    private Taskcard taskcard;

    // 是否转义 1 是 0 否（默认）
    /**
     * 转义是指会将发送内容中的用户ID和部门ID转化为用户名和部门名称
     */
    private Integer enableIdTrans;

    public TaskcardMessage(Taskcard taskcard) {

        super(MsgTypeEnum.TASKCARD.name().toLowerCase());

        this.taskcard = taskcard;
    }

    public Taskcard getTaskcard() {
        return taskcard;
    }

    public void setTaskcard(Taskcard taskcard) {
        this.taskcard = taskcard;
    }

    public Integer getEnableIdTrans() {
        return enableIdTrans;
    }

    public void setEnableIdTrans(Integer enableIdTrans) {
        this.enableIdTrans = enableIdTrans;
    }

    public static class Taskcard {

        // 标题
        private String title;

        // 描述
        private String description;

        // 跳转的地址
        private String url;

        // 任务ID
        private String taskId;

        // 按钮
        private List<Btn> btn;

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

        public String getTaskId() {
            return taskId;
        }

        public void setTaskId(String taskId) {
            this.taskId = taskId;
        }

        public List<Btn> getBtn() {
            return btn;
        }

        public void setBtn(List<Btn> btn) {
            this.btn = btn;
        }
    }

    public static class Btn {

        // 类似于主键（区分不同按钮）
        private String key;

        // 按钮名称
        private String name;

        // 点击后按钮的名称 默认：已处理
        private String replaceName;

        // 颜色
        private String color;

        // 字体是否加粗 默认false
        private Boolean isBold;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getReplaceName() {
            return replaceName;
        }

        public void setReplaceName(String replaceName) {
            this.replaceName = replaceName;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public Boolean getBold() {
            return isBold;
        }

        public void setBold(Boolean bold) {
            isBold = bold;
        }
    }
}
