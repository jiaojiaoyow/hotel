package com.example.hotel.service;

import com.example.hotel.model.VipCard;
import com.example.hotel.model.VipCardExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface VipService {
    long countByExample(VipCardExample example);

    int deleteByExample(VipCardExample example);

    int deleteByPrimaryKey(Integer vid);

    int insert(VipCard record);

    int insertSelective(VipCard record);

    List<VipCard> selectByExampleWithRowbounds(VipCardExample example, RowBounds rowBounds);

    List<VipCard> selectByExample(VipCardExample example);

    VipCard selectByPrimaryKey(Integer vid);

    int updateByExampleSelective(@Param("record") VipCard record, @Param("example") VipCardExample example);

    int updateByExample(@Param("record") VipCard record, @Param("example") VipCardExample example);

    int updateByPrimaryKeySelective(VipCard record);

    int updateByPrimaryKey(VipCard record);
}
