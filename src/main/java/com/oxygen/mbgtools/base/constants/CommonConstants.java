package com.oxygen.mbgtools.base.constants;


/**
 * 基础常量类
 * @author xuank
 *
 */
public class CommonConstants {

	// UTF8编码
	public static String UTF8_CHARSET = "utf-8";

	// json返回格式
	public static String JSON_FORMAT = "json";

	// 加密类型
	public static String RSA2_SIGN = "RSA2";

	/**
	 * 默认地址选取距离范围
	 */
	public static final int DEFAULT_DISTANCE = 200;

	public final static String  REPEAT_SIGN = "不能重复签到";


	public final static String  MSG_NOT_NULL = "必填参数不能为空";

	public final static String  MSG_EXCEPTION = "必填参数异常";

	public final static String  MSG_NO_ZERO_EXCEPTION = "必须大于等于0！";

	public final static String  MSG_NO_ONE_EXCEPTION = "必须大于0！";

	public final static String MSG_SYSTEM_EXCEPTION = "系统异常，请稍后再试！";

	public final static String MSG_PHONENO_EXCEPTION = "手机号格式错误！";

	public final static String  MSG_ERROR = "操作失败";

	public final static String  MSG_SUCCESS = "success";

	public final static String  USER_CHECK_PREFIX = "lifeplus:user:check:";

	public final static String  SHOPPER_TOKEN_PREFIX = "lifeplus:shopper:token:";

	public final static String  RIDER_TOKEN_PREFIX = "lifeplus:rider:token:";

	public final static String  USER_TOKEN_PREFIX = "lifeplus:user:token:";

	public final static String  USER_RED_POINT_PREFIX = "lifeplus:redPoint:";

	public final static String  USER_DISTANCE = "lifeplus:user:distance";

	public final static String  SHOPPER_CAPTCHA_PREFIX = "CAPTCHA:SHOPPER:";

	public final static String  RIDER_CAPTCHA_PREFIX = "CAPTCHA:RIDER:";

	public final static String  USER_CAPTCHA_PREFIX = "CAPTCHA:USER:";

	public final static String RIDER_ADVISER_NAME = "Rider:Adviser:Name";

	public final static String RIDER_ADVISER_PHONE = "Rider:Adviser:Phone";

	/**
	 * 跳转地址
	 */
	public final static String  appHome = "AppHome";  //原生首页

	public final static String  appMembership = "AppMembership";  //原生会员中心

	public final static String  appIntegral = "AppIntegral";     //原生积分

	public final static String  appMsg = "AppMsg";             //原生消息中心

	public final static String  appOrderDetail = "AppOrderDetail"; //原生订单详情

	public final static String  appMyComment = "AppMyComment";   //原生我的评价

	public final static String  appMine = "AppMine";           //原生个人中心

	public final static String  appRedPackage = "AppMine";    //原生我的红包

	public final static String  appSystemInfo = "AppSystemInfo";    //代金券返还跳转

	public final static String  appOrderInfo = "AppOrderInfo";    //代金券订单消息返还跳转

	/**
	 * 订单返回信息
	 */
	public final static String  orderStateNotPick = "订单状态不是待取餐";

	/**
	 * 订单返回信息
	 */
	public final static String  orderStateIsNull = "订单状态为空";

	/**
	 * 骑手接单接口返回信息
	 */
	public final static String  distributionMethodNotPlatform = "配送方式与骑手类型不匹配";

	/**
	 * 骑手接单接口返回信息
	 */
	public final static String  noDistributionMethod = "无此配送方式";

	/**
	 * 骑手接单接口返回信息
	 */
	public final static String  orderReceived = "该单已经被接了";

	/**
	 * 骑手完成送货接口返回信息 
	 */
	public final static String  orderStateNot4 = "订单状态不为4";

	/**
	 * 检查版本更新接口
	 */
	public final static String  noAppVersionDate = "无此数据";

	/**
	 * 加密价格redis key
	 */
	public final static String PRICE_AES = "lifeplus:price:aes";

	/**
	 * 加密价格redis key
	 */
	public final static String PRICE_AES_EXPIRE = "lifeplus:price:aes:expire";

}
