package com.example.hotel.Controller;

import com.example.hotel.DTO.ResultDTO;
import com.example.hotel.DTO.VipDTO;
import com.example.hotel.model.User;
import com.example.hotel.model.VipCard;
import com.example.hotel.service.UserService;
import com.example.hotel.service.VipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VipController {

    @Autowired
    private UserService userService;

    @Autowired
    private VipService vipService;

    @RequestMapping("/api/getVip")
    public ResultDTO getVip(VipDTO vipDTO){
        ResultDTO resultDTO=new ResultDTO();
        try {
            //新增Vip
            VipCard vipCard=new VipCard();
            vipCard.setGender(vipDTO.getGender());
            vipCard.setPhone(vipDTO.getPhone());
            vipCard.setUsername(vipDTO.getUsername());

            int flag=vipService.insertSelective(vipCard);
            if(flag==0){
                return resultDTO.fail("数据库插入失败");
            }
            //更改用户表
            User user=userService.selectByPrimaryKey(vipDTO.getUid());
            user.setStatus(1);
            userService.saveOrUpdate(user);
            return resultDTO.ok(null);
        }catch (Exception e){
            return resultDTO.unkonwFail(e.toString());
        }
    }
}
