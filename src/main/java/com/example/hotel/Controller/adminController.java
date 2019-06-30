package com.example.hotel.Controller;

import com.example.hotel.model.RoomOrder;
import com.example.hotel.model.TroRoom;
import com.example.hotel.service.RoomOrderService;
import com.example.hotel.service.TroRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class adminController {

    @Autowired
    private RoomOrderService roomOrderService;
    @Autowired
    private TroRoomService troRoomService;

    @RequestMapping("/api/getallorder")
    public List<RoomOrder> getAllOrder(){   //所有订单，包括失效完成

        List<RoomOrder> order =new ArrayList<RoomOrder>();
        order = roomOrderService.selectAllOrder();
        return order;

    }
    @RequestMapping("/api/getallpayorder")
    public List<RoomOrder> getAllPayOrder(){  //所有已成功付款待处理订单

        List<RoomOrder> order =new ArrayList<RoomOrder>();
        order = roomOrderService.selectAllPayOrder();
        return order;

    }
    @RequestMapping("/api/getallcompleteorder")
    public List<RoomOrder> getAllCompleteOrder(){   //所有已经完成订单
        List<RoomOrder> order =new ArrayList<RoomOrder>();
        order = roomOrderService.selectAllCompleteOrder();
        return order;
    }
    @RequestMapping("/api/getallroom")              //返回所有房间信息
    public List<TroRoom> getAllRoom(){
        List<TroRoom> troRooms=new ArrayList<TroRoom>();
        troRooms=troRoomService.selectAllTroRoom();
        return  troRooms;
    }
}
