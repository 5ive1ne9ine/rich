package com.oldduck.home.rich.mapper;

import com.oldduck.home.rich.dto.AccountInfoDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountInfoMapper {
    int deleteByPrimaryKey(Integer serialno);

    int insert(AccountInfoDto record);

    int insertSelective(AccountInfoDto record);

    AccountInfoDto selectByPrimaryKey(Integer serialno);

    int updateByPrimaryKeySelective(AccountInfoDto record);

    int updateByPrimaryKey(AccountInfoDto record);

    List<AccountInfoDto> selectByUserid(@Param("userId") String userId);
}