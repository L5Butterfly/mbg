package com.oxygen.mbgtools.mybatis.component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Json处理工具类
 * @author oxygen
 * @date 2020/7/3
 **/
public class JsonUtil {
    private static final Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    /**
     *
     * @param json
     * @param beanCalss
     * @param <T>
     * @return
     */
    public static <T> List<T> parseListfrom(String json, Class<T> beanCalss) {
    	    Type resultType = new TypeToken<List<T>>() {}.getType();
        return gson.fromJson(json, resultType);
    }


    /**
     *
     * @param json
     * @param beanCalss
     * @param <T>
     * @return
     */
    public static <T> T from(String json, Class<T> beanCalss) {
        return gson.fromJson(json, beanCalss);
    }

    /**
     *
     * @param json
     * @param beanType
     * @param <T>
     * @return
     */
    public static <T> T from(String json, Type beanType) {
        return gson.fromJson(json, beanType);
    }


    /**
     *
     * @param jsonElement
     * @param beanCalss
     * @param <T>
     * @return
     */
    public static <T> T from(JsonElement jsonElement, Class<T> beanCalss) {
        return gson.fromJson(jsonElement, beanCalss);
    }

    /**
     *
     * @param bean
     * @return
     */
    public static String toJson(Object bean) {
        return gson.toJson(bean);
    }

    /**
     *
     * @param jsonString
     * @return
     */
    public static JsonObject jsonObject(String jsonString){
        return gson.fromJson(jsonString, JsonObject.class);
    }
}

