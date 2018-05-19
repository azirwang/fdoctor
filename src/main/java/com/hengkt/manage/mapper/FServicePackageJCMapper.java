package com.hengkt.manage.mapper;

import com.hengkt.manage.model.FServicePackageJC;

public interface FServicePackageJCMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FServicePackageJC record);

    int insertSelective(FServicePackageJC record);

    FServicePackageJC selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FServicePackageJC record);

    int updateByPrimaryKey(FServicePackageJC record);
}