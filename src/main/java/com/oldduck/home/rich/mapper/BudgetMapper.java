package com.oldduck.home.rich.mapper;


import com.oldduck.home.rich.dto.BudgetDto;
import org.apache.ibatis.annotations.Param;

public interface BudgetMapper {
    int deleteByPrimaryKey(Integer serialno);

    int insert(BudgetDto record);

    int insertSelective(BudgetDto record);

    BudgetDto selectByPrimaryKey(Integer serialno);

    int updateByPrimaryKeySelective(BudgetDto record);

    int updateByPrimaryKey(BudgetDto record);

    BudgetDto selectByUserid(@Param("userId") String userId);
}