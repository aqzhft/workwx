package cc.powind.workwx.core;

import cc.powind.workwx.exception.RestException;

/**
 * 返回值 基础类
 */
public class BaseResponse {

    /**
     * 错误码
     */
    private Integer errcode;

    /**
     * 错误信息
     */
    private String errmsg;

    public BaseResponse() {
    }

    public BaseResponse(Integer errcode, String errmsg) {
        this.errcode = errcode;
        this.errmsg = errmsg;
    }

    public Integer getErrcode() {
        return errcode;
    }

    public void setErrcode(Integer errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public String getErrorMessage() {

        if (errcode != null && errcode == 0) {
            return null;
        }

        return errmsg;
    }

    public void validate() {

        if (errcode == null || errcode != 0) {
            throw new RestException(errmsg);
        }
    }

    @Override
    public String toString() {
        return "BaseResponse{" + "errcode=" + errcode + ", errmsg='" + errmsg + '\'' + '}';
    }
}
