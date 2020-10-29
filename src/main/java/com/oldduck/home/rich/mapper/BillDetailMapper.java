package com.oldduck.home.rich.mapper;

import com.oldduck.home.rich.dto.BillDetailDto;

public interface BillDetailMapper {
    int deleteByPrimaryKey(Integer serialno);

    int insert(BillDetailDto record);

    int insertSelective(BillDetailDto record);

    BillDetailDto selectByPrimaryKey(Integer serialno);

    int updateByPrimaryKeySelective(BillDetailDto record);

    int updateByPrimaryKey(BillDetailDto record);
}