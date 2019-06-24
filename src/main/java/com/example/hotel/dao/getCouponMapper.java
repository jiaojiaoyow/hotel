package com.example.hotel.dao;

import com.example.hotel.model.getCoupon;
import com.example.hotel.model.getCouponExample;
import com.example.hotel.model.getCouponKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface getCouponMapper {
    long countByExample(getCouponExample example);

    int deleteByExample(getCouponExample example);

    int deleteByPrimaryKey(getCouponKey key);

    int insert(getCoupon record);

    int insertSelective(getCoupon record);

    List<getCoupon> selectByExampleWithRowbounds(getCouponExample example, RowBounds rowBounds);

    List<getCoupon> selectByExample(getCouponExample example);

    getCoupon selectByPrimaryKey(getCouponKey key);

    int updateByExampleSelective(@Param("record") getCoupon record, @Param("example") getCouponExample example);

    int updateByExample(@Param("record") getCoupon record, @Param("example") getCouponExample example);

    int updateByPrimaryKeySelective(getCoupon record);

    int updateByPrimaryKey(getCoupon record);
}