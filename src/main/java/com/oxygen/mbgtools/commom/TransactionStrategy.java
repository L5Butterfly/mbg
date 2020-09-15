package com.oxygen.mbgtools.commom;

/**
 * 事务操作的模板方法的接口方法，Lambda表达式或者匿名类使用
 * @author oxygen
 *
 */
@FunctionalInterface
public interface TransactionStrategy {


	/**
	 * CommonException
	 * @FunctionalInterface
	 * 函数式编程，支持Lambda写法
	 *
	 * @throws Exception
	 */
	void execute() throws Exception;
}
