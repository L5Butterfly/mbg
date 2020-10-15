package com.oxygen.mbgtools.commom;

/**
 * 通用异常类
 * 项目内所有异常均要捕获封装成该类或其子类的异常后再抛出，并设置明确的code和msg信息
 * 
 */
public class CommonException extends RuntimeException {
    private static final long serialVersionUID = 4690312905649535054L;
    /**
     * 响应码中的占位符
     */
    public static final String FORMAT = "\\{\\}";
    /**
     * 响应码
     */
    private String code;
    /**
     * 响应信息
     */
    private String msg;

    public CommonException(String code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public CommonException(String code, String msg, String message) {
        super(message);
        this.code = code;
        this.msg = msg;
    }

    public CommonException(String code, String msg, Throwable cause) {
        super(msg, cause);
        this.code = code;
        this.msg = msg;
    }

    public CommonException(String code, String msg, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * 替换响应码消息中的占位符{}
     *
     * @param msg  响应码消息
     * @param objs 替换参数
     * @return 替换后的响应码消息
     */
    public static String replace(String msg, Object... objs) {
        if (objs == null) {
            return msg;
        }
        for (Object obj : objs) {
            msg = msg.replaceFirst(FORMAT, obj.toString());
        }
        return msg;
    }

    /**
     * 适用于美杜莎翻译的变量规则替换
     *
     * @param msg  响应码消息
     * @param objs 替换参数
     * @return 替换后的响应码消息
     */
    public static String mcmReplace(String msg, Object... objs) {
        if (objs == null) {
            return msg;
        }
        for (Object obj : objs) {
            msg = msg.replaceFirst(FORMAT, "\\[" + obj.toString() + "\\]");
        }
        return msg;
    }
}
