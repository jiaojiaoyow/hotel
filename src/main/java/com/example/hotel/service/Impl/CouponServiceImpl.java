package com.example.hotel.service.Impl;

import com.example.hotel.dao.CouponMapper;
import com.example.hotel.model.Coupon;
import com.example.hotel.model.CouponExample;
import com.example.hotel.service.CouponService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CouponService")
public class CouponServiceImpl implements CouponService {
    @Autowired
    private CouponMapper couponMapper;

    @Override
    public long countByExample(CouponExample example) {
        return 0;
    }

    @Override
    public int deleteByExample(CouponExample example) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(Integer cid) {
        return 0;
    }

    @Override
    public int insert(Coupon record) {
        return 0;
    }

    @Override
    public int insertSelective(Coupon record) {
        return 0;
    }

    @Override
    public List<Coupon> selectByExampleWithRowbounds(CouponExample example, RowBounds rowBounds) {
        return null;
    }

    @Override
    public List<Coupon> selectByExample(CouponExample example) {
        return null;
    }

    @Override
    public Coupon selectByPrimaryKey(Integer cid) {
        return couponMapper.selectByPrimaryKey(cid);
    }

    @Override
    public int updateByExampleSelective(Coupon record, CouponExample example) {
        return 0;
    }

    @Override
    public int updateByExample(Coupon record, CouponExample example) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(Coupon record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Coupon record) {
        return 0;
    }
}