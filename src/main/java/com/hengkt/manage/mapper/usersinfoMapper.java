package com.hengkt.manage.mapper;

import com.hengkt.manage.model.usersinfo;

public interface usersinfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(usersinfo record);

    int insertSelective(usersinfo record);

    usersinfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(usersinfo record);

    int updateByPrimaryKey(usersinfo record);
}