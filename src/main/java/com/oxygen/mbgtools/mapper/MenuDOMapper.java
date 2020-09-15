package com.oxygen.mbgtools.mapper;

import com.oxygen.mbgtools.domain.MenuDO;
import com.oxygen.mbgtools.domain.MenuDOExample;
import com.oxygen.mbgtools.mybatis.bean.BaseMapper;
import javax.annotation.Resource;

@Resource
public interface MenuDOMapper extends BaseMapper<MenuDO, MenuDOExample> {
}