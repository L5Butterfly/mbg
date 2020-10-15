package com.oxygen.mbgtools.commom;


/**
 * 
 * @description  错误码
 * @date 2020/5/8 15:57
 **/
public enum CommonCodeEnum {

    SUCCESS_ZERO("0", "成功"),
    EXCEPTION("1","异常"),
    FAIL("-1","失败"),
    SUCCESS("00000000", "成功"),
    PARAM_ERROR("00001101", "用户输入参数错误!"),
    DB_FAIL("00002301", "数据库操作失败"),
    DB_EXCEPTION("40000000", "数据库操作异常!"),
    RUNTIME_ERROR("50000000", "其他运行异常");

    private String code;
    private String msg;

    /**
     * 构造方法
     * @param code
     * @param msg
     */
    private CommonCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
}
