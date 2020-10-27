package com.oldduck.home.rich.dao;

import com.oldduck.home.rich.dto.BillDetailDto;

public interface BillDetailDao {
    int deleteByPrimaryKey(Integer serialno);

    int insert(BillDetailDto record);

    int insertSelective(BillDetailDto record);

    BillDetailDto selectByPrimaryKey(Integer serialno);

    int updateByPrimaryKeySelective(BillDetailDto record);

    int updateByPrimaryKey(BillDetailDto record);
}