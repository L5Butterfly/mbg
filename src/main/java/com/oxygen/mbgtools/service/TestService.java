package com.oxygen.mbgtools.service;

 /**
  * 王超
  * @author wangchao
  * @date 2020/9/21 14:21
  * @created by oxygen
  */
public class TestService {

	public static void main(String[] args) {
		String a="0.5";
		Float aFloat = Float.valueOf(a);
		Float v = aFloat * 24;
		String s = v.toString();
		Long aLong = Long.parseLong(s.substring(0,s.length()-2));
		System.out.println(aLong);
	}
}
