package com.oxygen.mbgtools.commom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * 事务操作的模板方法，对外屏蔽事务提交回滚操作细节
 * 手动控制数据库事务，不用交个Spring容器管理
 * 可以使用xml的方式配置bean--------spring-mybatis配置
 * @author oxygen
 */

@Component
public class TransactionUtil {


    /**
     * PlatformTransactionManager 事务管理器
     * TransactionDefinition 事务的一些基础信息，如超时时间、隔离级别、传播属性等
     * TransactionStatus 事务的一些状态信息，如是否一个新的事务、是否已被标记为回滚
     */
    @Autowired
    private PlatformTransactionManager financeTransactionManager;


    /**
     * 事务控制方法1
     * @param strategy
     * @throws CommonException
     */
    public void executeTransaction(TransactionStrategy strategy) throws CommonException {
        TransactionParam param = new TransactionParam(CommonCodeEnum.DB_FAIL.getCode(), CommonCodeEnum.DB_FAIL.getMsg());
        this.executeTransaction(strategy, param);
    }


    /**
     * 事务控制方法2
     * @param strategy
     * @param code
     * @param msg
     * @throws CommonException
     */
    public void executeTransaction(TransactionStrategy strategy, String code, String msg) throws CommonException {
        TransactionParam param = new TransactionParam(code, msg);
        this.executeTransaction(strategy, param);
    }


    /**
     * 事务控制方法3
     * @param strategy
     * @param param
     * @throws CommonException
     */
    public void executeTransaction(TransactionStrategy strategy, TransactionParam param) throws CommonException {
        TransactionStatus transaction = this.beginTransaction();
        try {
            strategy.execute();
        } catch (CommonException e) {
            this.rollbackTransaction(transaction);
            throw e;
        } catch (Exception e) {
            this.rollbackTransaction(transaction);
            if (param.getDesc() == null) {
                throw new CommonException(param.getCode(), param.getMsg(), e);
            } else {
                throw new CommonException(param.getCode(), param.getMsg(), param.getDesc(), e);
            }
        }
        this.commitTransaction(transaction);
    }

    /**
     * 开启事务
     *
     * @return
     */
    private TransactionStatus beginTransaction() {
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        return financeTransactionManager.getTransaction(def);
    }


    /**
     * 提交事务
     *
     * @param txStatus
     */
    private void commitTransaction(TransactionStatus txStatus) {
        financeTransactionManager.commit(txStatus);
    }

    /**
     * 回滚事务
     *
     * @param txStatus
     */
    private void rollbackTransaction(TransactionStatus txStatus) {
        financeTransactionManager.rollback(txStatus);
    }

}
