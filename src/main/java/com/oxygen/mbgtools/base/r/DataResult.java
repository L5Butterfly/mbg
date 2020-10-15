package com.oxygen.mbgtools.base.r;

import com.oxygen.mbgtools.commom.CommonCodeEnum;

import java.io.Serializable;

/**
 * 数据响应结果
 *
 * @param <T> 任意返回数据对象
 * @author emapthy
 * HSF等远程调用或者前后端JSON等交响应结果
 */
public class DataResult<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 响应码 00000000 与 0 成功,其他失败
     */
    private String code;
    /**
     * 响应信息
     */
    private String msg;
    /**
     * 总记录数，默认为0
     */
    private Integer total = 0;
    /**
     * traceId
     */
    private String traceId;
    /**
     * 返回数据对象
     */
    private T data;

    public static <T> DataResult<T> getInstance() {
        DataResult<T> result = new DataResult<T>();
        result.setCode(null);
        result.setMsg(null);
        return result;
    }

    public DataResult() {
        super();
        this.code = CommonCodeEnum.SUCCESS.getCode();
        this.msg = CommonCodeEnum.SUCCESS.getMsg();
    }

    public DataResult(T data) {
        super();
        this.code = CommonCodeEnum.SUCCESS.getCode();
        this.msg = CommonCodeEnum.SUCCESS.getMsg();
        this.data = data;
    }

    public DataResult(T data, Integer total) {
        super();
        this.code = CommonCodeEnum.SUCCESS.getCode();
        this.msg = CommonCodeEnum.SUCCESS.getMsg();
        this.data = data;
        this.total = total;
    }

    public DataResult(String code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }

    public DataResult(String code, String msg, T data) {
        super();
        this.data = data;
        this.code = code;
        this.msg = msg;
    }

    public DataResult(String code, String msg, T data, Integer total) {
        super();
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.total = total;
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

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public T getData() {
        return data;
    }

    public void setData(T
                            data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return CommonCodeEnum.SUCCESS.getCode().equals(this.code) || CommonCodeEnum.SUCCESS_ZERO.getCode().equals(
            this.code);
    }

    public boolean isPending() {
        return CommonCodeEnum.EXCEPTION.getCode().equals(this.code);
    }

    @Override
    public String toString() {
        return "DataResult [code=" + code + ", msg=" + msg + ", total=" + total + ", data=" + data + "]";
    }

    public static class DataResultBuilder {

        /**
         * 成功
         */
        public final static String SUCCESS = "0";

        private DataResultBuilder() {

        }

        private String code;
        private String subCode;
        private String msg;
        private Object data;
        private static String APP_NAME = System.getProperty("spring.application.name", "UNKNOW");
        private Object[] param;

        public static DataResultBuilder newBuilder() {
            return new DataResultBuilder();
        }

        /**
         * 0:服务中断异常
         **/
        public static DataResultBuilder c0() {
            return newBuilder().code("0").msg("SUCCESS");
        }

        /**
         * 2000:服务中断异常
         **/
        public static DataResultBuilder c2000() {
            return newBuilder().code("2000").msg("Server Error");
        }

        /**
         * 3000:权限类异常
         **/
        public static DataResultBuilder c3001() {
            return newBuilder().code("3001").msg("No Service Authority");
        }

        public static DataResultBuilder c3002() {
            return newBuilder().code("3002").msg("Signature Error");
        }

        public static DataResultBuilder c3003() {
            return newBuilder().code("3003").msg("No Data Authority");
        }

        /**    4000:参数类异常     **/
        /**
         * 缺少参数
         *
         * @param arg
         * @return
         */
        public static DataResultBuilder c4001(Object arg) {
            return newBuilder().code("4001").msg("Missing Parameter : %s", arg);
        }

        public static DataResultBuilder c4002(Object arg) {
            return newBuilder().code("4002").msg("Illegal Parameter : %s", arg);
        }

        public static DataResultBuilder c4003(Object arg) {
            return newBuilder().code("4003").msg("Parameter Error : %s", arg);
        }

        /**
         * 5000:业务处理异常（非block）
         **/
        public static DataResultBuilder c5000(Object arg) {
            return newBuilder().code("5000").msg("业务处理异常(非block) : %s", arg);
        }

        /**
         * 超出限制
         *
         * @param arg
         * @return
         */
        public static DataResultBuilder c5001(Object arg) {
            return newBuilder().code("5001").msg("Exceeding limit: %s", arg);
        }

        /**
         * 重复处理
         *
         * @param arg
         * @return
         */
        public static DataResultBuilder c5002(Object arg) {
            return newBuilder().code("5002").msg("Repetitive Processing : %s", arg);
        }

        /**
         * 6000:业务处理异常（block）
         **/
        public static DataResultBuilder c6000(Object arg) {
            return newBuilder().code("6000").msg("业务处理异常(block) : %s", arg);
        }

        /**
         * 未发现相关数据
         *
         * @param arg
         * @return
         */
        public static DataResultBuilder c6001(Object arg) {
            return newBuilder().code("6001").msg("Not found : %s", arg);
        }

        /**
         * 数据不一致
         *
         * @param arg
         * @return
         */
        public static DataResultBuilder c6002(Object arg) {
            return newBuilder().code("6002").msg("Data Inconsistency : %s", arg);
        }

        /**
         * 无配置
         *
         * @param arg
         * @return
         */
        public static DataResultBuilder c6003(Object arg) {
            return newBuilder().code("6003").msg("Without Config : %s", arg);
        }

        /**
         * 7000:外部依赖异常
         **/
        public static DataResultBuilder c7000(Object arg) {
            return newBuilder().code("7000").msg("External System Error : %s", arg);
        }

        public static DataResultBuilder c7001(Object arg) {
            return newBuilder().code("7001").msg("External System Error(HSF) : %s", arg);
        }

        public static DataResultBuilder c7002(Object arg) {
            return newBuilder().code("7002").msg("External System Error(HTTP) : %s", arg);
        }

        /**
         * 9000:未归类系统异常
         **/
        public static DataResultBuilder c9000(Object arg) {
            return newBuilder().code("9000").msg("System Error : %s", arg);
        }

        public DataResultBuilder code(String code) {
            this.code = code;
            return this;
        }

        public DataResultBuilder subCode(String msg) {
            this.subCode = subCode;
            return this;
        }

        public DataResultBuilder msg(String msg) {
            this.msg = msg;
            return this;
        }

        public DataResultBuilder param(Object... param) {
            this.param = param;
            return this;
        }

        public DataResultBuilder msg(String msg, Object... param) {
            this.msg = msg;
            this.param = param;
            return this;
        }

        public DataResultBuilder data(Object data) {
            this.data = data;
            return this;
        }

        public DataResult build() {
            DataResult dataResult = new DataResult();
            if (this.code == null) {
                throw new IllegalArgumentException("code can't be null");
            }

            dataResult.setCode(new StringBuffer(this.code)
                .append(".").append(APP_NAME).append(".").append(subCode == null ? "" : subCode).toString());
            if (param == null) {
                dataResult.setMsg(msg);
            } else {
                dataResult.setMsg(String.format(msg, param));
            }
            dataResult.setData(data);

            return dataResult;
        }

    }
}
