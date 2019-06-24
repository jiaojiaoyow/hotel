package com.example.hotel.Controller;


import com.example.hotel.DTO.cOrderDTO;
import com.example.hotel.model.Coupon;
import com.example.hotel.model.Room;
import com.example.hotel.model.RoomOrder;
import com.example.hotel.service.CouponService;
import com.example.hotel.service.RoomOrderService;
import com.example.hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;


@RestController
public class CreateOrderController {


    @Autowired
    private RoomService roomService;
    @Autowired
    private RoomOrderService roomOrderService;
    @Autowired
    private CouponService couponService;

    //检查优惠卷
    public  Double getCoupon(int cid){
        if(cid != 0  ) {
            Coupon coupon = couponService.selectByPrimaryKey(cid);
            if (coupon != null ) {
                Double amount = coupon.getAmount();

                return amount;
            }
        }
        return 0.0;
    }

    //创建订单
    @RequestMapping("/api/createorder")
    public cOrderDTO createOrder(@RequestBody RoomOrder roomOrder){

        try{
        //HttpServletRequest request
        if(roomOrder !=null) {

            String uid = roomOrder.getUid();                 //"1234";
            String roomname = roomOrder.getRoomname();       //"阳光大床房";
            String ordertime = roomOrder.getOrdertime();     //"2019-06-20";
            String leavetime = roomOrder.getLeavetime();     //"2019-06-21";
            int days = roomOrder.getOrderday();             //2;
            int roomnumber = roomOrder.getRoomnumber();     //2;
            String username = roomOrder.getUname();         //"许文强";
            String uphone = roomOrder.getUphone();          //"18316102612";
            String arrivetime = roomOrder.getArrivetime();    //到达时间
            Room r = roomService.selectByPrimaryKey(roomname);//查询roomname的房间信息
            if (r != null) {
                int num = r.getRoomnumber(); //剩余房间数
                if (num > 0 && num - roomnumber >= 0) {
                    double amount = getCoupon(roomOrder.getCid());
                    double price = r.getRoomprice() * roomnumber * days - amount; //总价，算优惠卷
                    String s = DateToString();
                    ordertime += s.substring(10);
                    leavetime += s.substring(10);
                    RoomOrder order = new RoomOrder();
                    order.setUid(uid);
                    order.setRoomnumber(roomnumber);
                    order.setUname(username);
                    order.setUphone(uphone);
                    order.setRoomname(roomname);
                    order.setTotalprice(price);
                    order.setOrdertime(ordertime);
                    order.setLeavetime(leavetime);
                    order.setArrivetime(arrivetime);

                    int a = roomService.updateByPrimaryKeyForReduce(roomname, roomnumber);//更新房间数
                    if (a != 1) {
                        System.out.println("所选房间剩余不足");
                        return null;
                    }
                    roomOrderService.insertSelective(order); //创建订单
                    RoomOrder rm = new RoomOrder();
                    rm.setOrdertime(ordertime);
                    rm.setRoomname(roomname);
                    rm.setUid(uid);
                    int orderid = roomOrderService.selectByRDU(rm);//订单id


                    cOrderDTO cd = new cOrderDTO(uid, orderid, 1, 0.0);

                    return cd;
                } else {
                    System.out.println("房间不足");
                    return null;
                }

            }
        }
        }catch(Exception e){
            System.out.println(e);

        }
        System.out.println("数据为空");
            return null;
    }


    //判断支付是否成功
    @RequestMapping("/api/judgeorder")
    public String JudgeOrder(@RequestBody cOrderDTO Dt){

        if(Dt !=null){
            RoomOrder re=roomOrderService.selectByOrderid(Dt.getOrderid());

            if( Dt.getUid().equals(re.getUid()) &&  re.getOrderstatus()==1 ) { //uid相同且订单状态为1
                RoomOrder roomOrder=new RoomOrder();
                roomOrder.setUid(Dt.getUid());
                roomOrder.setOrderid(re.getOrderid());
                roomOrder.setRoomname(re.getRoomname());
                if (Dt.getStatus() == 2) {  //支付成功

                    if (Dt.getBalance() != 0.0) {//余额


                    }
                    //设定优惠卷生效
                    roomOrder.setOrderstatus(2);
                    roomOrderService.updateByPrimaryKeySelective(roomOrder);//更改订单为2 成功
                    return "订单成功。";

                } else {//数据回滚
                    roomService.updateByPrimaryKeyForNum(re.getRoomname(),re.getRoomnumber());
                    roomOrder.setOrderstatus(3);
                    roomOrderService.updateByPrimaryKeySelective(roomOrder);//更改订单为3，作废
                    return "订单失败。";
                }


            }
        }
        return "订单失败。";
    }

    //获取当前时间
    public static String DateToString() {
        String dateStr = "hhh";

        try{
            java.util.Date  date = new Date();
            SimpleDateFormat DF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            dateStr = DF.format(date);

        } catch (Exception e) {
            System.out.println("Date error");
        }
        return dateStr;
    }

}
