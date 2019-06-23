package com.example.hotel.Controller;

import com.alibaba.fastjson.JSON;
import com.example.hotel.DTO.cOrderDTO;
import com.example.hotel.model.Room;
import com.example.hotel.model.RoomOrder;
import com.example.hotel.model.RoomOrderKey;
import com.example.hotel.service.CouponService;
import com.example.hotel.service.RoomOrderService;
import com.example.hotel.service.RoomService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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




    @RequestMapping("/api/createorder")
    public cOrderDTO createOrder(){  //创建订单

        //HttpServletRequest request




            String uid = "1234";
            String roomname = "阳光大床房";
            String ordertime = "2019-06-20";
            String leavetime = "2019-06-21";
            int days = 2;
            int roomnumber = 18;
            String username = "许文强";
            String uphone = "18316102612";
            Room r = roomService.selectByPrimaryKey(roomname);//查询roomname的房间信息
            if (r != null) {
                int num = r.getRoomnumber(); //剩余房间数
                if (num > 0 && num - roomnumber >= 0) {

                    double price = r.getRoomprice() * roomnumber * days; //总价，不算优惠卷
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
                    roomOrderService.insertSelective(order); //创建订单
                    Room re = new Room();
                    re.setRoomnumber(num - roomnumber);
                    re.setRoomname(roomname);
                    roomService.updateByPrimaryKeySelective(re);//更新房间数

                    RoomOrder rm=new RoomOrder();
                    rm.setOrdertime(ordertime);
                    rm.setRoomname(roomname);
                    rm.setUid(uid);
                    int orderid = roomOrderService.selectByRDU(rm);//订单id


                    cOrderDTO cd=new cOrderDTO(uid,orderid,roomname,roomnumber,1);
                    System.out.println("创建订单成功");

                    return cd;
                } else {
                    System.out.println("房间不足");
                    return null;
                }

            }


        System.out.println("数据为空");
        return null;
    }

    public  void getCoupon(int cid){
        couponService.selectByPrimaryKey(cid);
    }




/*
    @RequestMapping("/api/createorder")
    public cOrderDTO createOrder(@RequestBody  RoomOrder roomOrder,int cid){  //创建订单

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
            Room r = roomService.selectByPrimaryKey(roomname);//查询roomname的房间信息
            if (r != null) {
                int num = r.getRoomnumber(); //剩余房间数
                if (num > 0 && num - roomnumber >= 0) {

                    double price = r.getRoomprice() * roomnumber * days; //总价，不算优惠卷
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
                    roomOrderService.insertSelective(order); //创建订单
                    Room re = new Room();
                    re.setRoomnumber(num - roomnumber);
                    re.setRoomname(roomname);
                    roomService.updateByPrimaryKeySelective(re);//更新房间数

                    RoomOrder rm=new RoomOrder();
                    rm.setOrdertime(ordertime);
                    rm.setRoomname(roomname);
                    rm.setUid(uid);
                    int orderid = roomOrderService.selectByRDU(rm);//订单id


                    cOrderDTO cd=new cOrderDTO(uid,orderid,roomname,roomnumber,1);

                    return cd;
                } else {
                    System.out.println("房间不足");
                    return null;
                }

            }

        }
        System.out.println("数据为空");
            return null;
    }*/

    @RequestMapping("/judgeorder")
    @ResponseBody
    public void JudgeOrder(cOrderDTO Dt){
        String uid="1234";

        if(Dt !=null){

            RoomOrder roomOrder=new RoomOrder();
            roomOrder.setUid(Dt.getUid());
            roomOrder.setRoomname(Dt.getRname());
            roomOrder.setOrderid(Dt.getOrderid());
                if(Dt.getStatus()==2){  //支付成功
                    roomOrder.setOrderstatus(2);
                    roomOrderService.updateByPrimaryKeySelective(roomOrder);//更改订单为2

            }else{
                Room re = roomService.selectByPrimaryKey(Dt.getRname());
                int number=re.getRoomnumber();
                Room r=new Room();
                r.setRoomname(Dt.getRname());
                r.setRoomnumber(number+Dt.getNumber());
                roomService.updateByPrimaryKeySelective(r);

               // RoomOrderKey key=new RoomOrderKey(Dt.getOrderid(),Dt.getUid(),Dt.getRname());


                roomOrder.setOrderstatus(3);
                roomOrderService.updateByPrimaryKeySelective(roomOrder);//更改订单为3，作废

            }



        }
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
