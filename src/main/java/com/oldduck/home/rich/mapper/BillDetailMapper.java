package com.oldduck.home.rich.mapper;

import com.oldduck.home.rich.dto.BillDetailDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BillDetailMapper {
    int deleteByPrimaryKey(Integer serialno);

    int insert(BillDetailDto record);

    int insertSelective(BillDetailDto record);

    BillDetailDto selectByPrimaryKey(Integer serialno);

    int updateByPrimaryKeySelective(BillDetailDto record);

    int updateByPrimaryKey(BillDetailDto record);

    List<BillDetailDto> selectDataByUseridYeatMonth(@Param("userId") String userId, @Param("month") String month);
}