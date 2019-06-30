package com.example.hotel.Controller;

import com.example.hotel.DTO.ResultDTO;
import com.example.hotel.model.Admin;
import com.example.hotel.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class AdminLoginController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/api/back/login")
    public ResultDTO login(String uname, String password){
        ResultDTO resultDTO=new ResultDTO();
        try {
            Admin admin=adminService.selectByUname(uname);
            if(admin.getPassword()==password){
                return resultDTO.fail("密码错误");
            }
            return resultDTO.ok(null);
        }catch (Exception e){
            return resultDTO.unkonwFail(e.toString());
        }
    }
}
