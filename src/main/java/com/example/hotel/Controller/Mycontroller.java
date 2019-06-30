package com.example.hotel.Controller;

import com.example.hotel.model.RoomOrder;
import com.example.hotel.service.RoomOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Mycontroller {

    @Autowired
    private RoomOrderService roomOrderService;

    @RequestMapping("/api/getorder")
    public List<RoomOrder> getOrder(@RequestBody String openid){


        List<RoomOrder> roomOrder=new ArrayList<RoomOrder>();
        roomOrder=roomOrderService.selectByUserid(openid); //返回的是已经成功的订单
        System.out.println("返回所有已支付订单成功。");

        return roomOrder;
    }

}
