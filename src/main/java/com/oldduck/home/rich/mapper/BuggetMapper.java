package com.oldduck.home.rich.mapper;

import com.oldduck.home.rich.dto.BuggetDto;
import org.apache.ibatis.annotations.Param;

public interface BuggetMapper {
    int deleteByPrimaryKey(Integer serialno);

    int insert(BuggetDto record);

    int insertSelective(BuggetDto record);

    BuggetDto selectByPrimaryKey(Integer serialno);

    int updateByPrimaryKeySelective(BuggetDto record);

    int updateByPrimaryKey(BuggetDto record);

    BuggetDto selectByUserid(@Param("userId") String userId);
}