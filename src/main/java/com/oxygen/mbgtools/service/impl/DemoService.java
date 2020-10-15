package com.oxygen.mbgtools.service.impl;

import com.oxygen.mbgtools.base.exception.AbstractException;
import com.oxygen.mbgtools.base.exception.BizException;
import com.oxygen.mbgtools.service.IDemo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


 /**
  * DemoService
  * @author Administrator
  * @date 2020/10/15 16:30
  * @created by oxygen
  */
@Service
@Slf4j
public class DemoService implements IDemo {


	@Override
	public void save() {

		throw new BizException(1001,"error");

	}
}
