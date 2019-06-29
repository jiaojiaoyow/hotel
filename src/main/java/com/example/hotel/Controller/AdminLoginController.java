package com.example.hotel.Controller;

import com.example.hotel.DTO.ResultDTO;
import com.example.hotel.model.Admin;
import com.example.hotel.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class AdminLoginController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("login")
    public ResultDTO login(String uname, String password, HttpSession session){
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
