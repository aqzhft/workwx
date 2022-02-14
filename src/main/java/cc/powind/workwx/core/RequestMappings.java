package cc.powind.workwx.core;

public class RequestMappings {

    public enum TOKEN {

        GET_ACCESS_TOKEN("/cgi-bin/gettoken?corpid=%s&corpsecret=%s");

        private String value;

        public String getValue() {
            return value;
        }

        TOKEN(String value) {
            this.value = value;
        }
    }


}
