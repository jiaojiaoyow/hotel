package com.example.hotel.service;

import com.example.hotel.model.Coupon;
import com.example.hotel.model.CouponExample;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface CouponService {


    long countByExample(CouponExample example);

    int deleteByExample(CouponExample example);

    int deleteByPrimaryKey(Integer cid);

    int insert(Coupon record);

    int insertSelective(Coupon record);

    List<Coupon> selectByExampleWithRowbounds(CouponExample example, RowBounds rowBounds);

    List<Coupon> selectByExample(CouponExample example);

    Coupon selectByPrimaryKey(Integer cid);

    int updateByExampleSelective(@Param("record") Coupon record, @Param("example") CouponExample example);

    int updateByExample(@Param("record") Coupon record, @Param("example") CouponExample example);

    int updateByPrimaryKeySelective(Coupon record);

    int updateByPrimaryKey(Coupon record);


    List<Coupon> SelectAll();
}

