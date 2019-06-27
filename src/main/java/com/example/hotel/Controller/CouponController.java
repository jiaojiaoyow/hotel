package com.example.hotel.Controller;

import com.example.hotel.model.Coupon;
import com.example.hotel.model.GetCoupon;
import com.example.hotel.service.CouponService;
import com.example.hotel.service.GetCouponService;
import com.example.hotel.adapter.CouponUtil;
import com.example.hotel.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@RestController
public class CouponController {
    @Autowired
    private CouponService couponService;

    @Autowired
    private CouponUtil couponUtil;

    @Autowired
    private GetCouponService getCouponService;

    //获取所有的优惠卷，供主界面展示用
    @RequestMapping("/selCoupon")
    public List<Coupon> Sel_message() throws ParseException {
        List<Coupon> mess=couponService.SelectAll();
        //如果结束时间大于系统给的时间，这在数据库中删除数据，并且不返回。
        couponUtil.FilterTime(mess);
        return mess;
    }

    //查询用户个人拥有的不过期的优惠卷,传回uid
    @RequestMapping("selUserCoupon")
    public List<Coupon> Sel_User_message(String uid) throws ParseException{
        Date nowtime=new Date();
        List<Coupon> UserCoupon=null;
        List<GetCoupon> mess=getCouponService.selectByUid(uid);
        for (GetCoupon temp:mess
             ) {
            if(temp.getStatus()!=0&&DateUtil.change_Date(temp.getUseEndDate()).getTime()<nowtime.getTime()){
                UserCoupon.add(couponService.selectByPrimaryKey(temp.getCid()));
            }
            else {
                couponService.deleteByPrimaryKey(temp.getCid());
            }
        }
        return UserCoupon;
    }

    //领取优惠卷,需要前端传回uid，cid，cname
    @RequestMapping("getCoupon")
    public void get_coupon(@RequestBody GetCoupon getCoupon){
        Date nowtime=new Date();
        //设置开始和结束时间
        getCoupon.setUseStartDate(DateUtil.change_str(nowtime));
        getCoupon.setUseEndDate(DateUtil.addtime(nowtime,5));//有五天的时间
        getCouponService.insert(getCoupon);
    }
}
