package com.oxygen.mbgtools.commom.utils;

import com.oxygen.mbgtools.commom.dto.User;


/**
 * 请求上下文用户信息
 * @author oxygen
 * @date 2020/7/6
 **/
public class HsfContextUtil {

    /**
     * 默认系统用户
     */
    public static final User SYSTEM_USER = new User();

    static {
        SYSTEM_USER.setId(0);
        SYSTEM_USER.setEmployeeId("0");
        SYSTEM_USER.setName("系统");
        SYSTEM_USER.setLanguage("zh");
    }

    /**
     * 当前用户
     */
    private static ThreadLocal<User> currentUser = new ThreadLocal<User>();

    /**
     * 获取当前用户信息. <br/>
     *
     * @return
     */
    public static User getCurrentUser() {
        User u = currentUser.get();
        if (u == null) {
            return SYSTEM_USER;
        } else {
            return u;
        }
    }

    /**
     * 设置当前请求的用户信息. <br/>
     *
     * @param user
     */
    public static void setCurrentUser(User user) {
        currentUser.set(user);
    }

    /**
     * 每次请求结束时需要清空线程上下文，避免内存泄露. <br/>
     */
    public static void remove() {
        currentUser.remove();
    }
}
