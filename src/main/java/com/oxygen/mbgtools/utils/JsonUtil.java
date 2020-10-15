package com.oxygen.mbgtools.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;

/**
 * JSON转化工具类
 * @author wangchao
 * @date 2020/9/17 14:46
 * @created by oxygen
 */
public class JsonUtil {

	/**
	 * Json技术选择建议方案: 在项目选型的时候可以使用Google的Gson和阿里巴巴的FastJson两种并行使用，
	 * 如果只是功能要求，没有性能要求，可以使用google的Gson，
	 * 如果有性能上面的要求可以使用Gson将bean转换json确保数据的正确，使用FastJson将Json转换Bean
	 */
   private static final Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

   public static <T> List<T> parseListFrom(String json, Class<T> beanClass) {
	   Type resultType = new TypeToken<List<T>>() {}.getType();
	   return gson.fromJson(json, resultType);
   }

   public static <T> T from(String json, Class<T> beanClass) {
	   return gson.fromJson(json, beanClass);
   }

   public static <T> T from(String json, Type beanType) {
	   return gson.fromJson(json, beanType);
   }

   public static <T> T from(JsonElement jsonElement, Class<T> beanClass) {
	   return gson.fromJson(jsonElement, beanClass);
   }

   public static String toJson(Object bean) {
	   return gson.toJson(bean);
   }

   public static JsonObject jsonObject(String jsonString){
	   return gson.fromJson(jsonString, JsonObject.class);
   }
}

