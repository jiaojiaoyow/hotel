package com.example.hotel.Controller;

import com.example.hotel.model.RoomOrder;
import com.example.hotel.service.RoomOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Mycontroller {

    @Autowired
    private RoomOrderService roomOrderService;

    @RequestMapping("/api/getorder")
    public List<RoomOrder> getOrder(){

        String uid="1234";
        List<RoomOrder> roomOrder=new ArrayList<RoomOrder>();
        roomOrder=roomOrderService.selectByUserid(uid);
        return roomOrder;
    }

}
