package com.oldduck.home.rich.mapper;

import com.oldduck.home.rich.dto.UserInfoDto;

public interface UserInfoMapper {
    int deleteByPrimaryKey(Integer serialno);

    int insert(UserInfoDto record);

    int insertSelective(UserInfoDto record);

    UserInfoDto selectByPrimaryKey(Integer serialno);

    int updateByPrimaryKeySelective(UserInfoDto record);

    int updateByPrimaryKey(UserInfoDto record);
}