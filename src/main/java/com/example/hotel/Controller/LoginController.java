package com.example.hotel.Controller;

import com.example.hotel.DTO.LoginDTO;
import com.example.hotel.DTO.ResultDTO;
import com.example.hotel.DTO.SessionDTO;
import com.example.hotel.adapter.WechatAdapter;
import com.example.hotel.error.CommonErrorCode;
import com.example.hotel.error.ErrorCodeException;
import com.example.hotel.model.User;
import com.example.hotel.service.UserService;
import com.example.hotel.util.DigestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSON;

/**
 * 不要在意get和set方法的
 */
@RestController
public class LoginController {
    @Autowired
    private WechatAdapter wechatAdapter;

    @Autowired
    private UserService userService;

    @RequestMapping("/api/login")
    public ResultDTO login(@RequestBody LoginDTO loginDTO){
        try{

            //使用code调用微信api来获取openid和
            SessionDTO sessionDTO=wechatAdapter.jscode2session(loginDTO.getCode());
            //检验传递过来的用户信息是否合法
            DigestUtil.checkDigest(loginDTO.getRawData(),sessionDTO.getSessionKey(),loginDTO.getSignature());


            //保存微信来的数据
            User user=JSON.parseObject(loginDTO.getRawData(),User.class);
            user.setUid(sessionDTO.getOpenid());
            userService.insert(user);
            //生成token，用于自定义登录态，这里的存储逻辑比较复杂，放到下一讲

            return ResultDTO.ok("ok");
        }catch (ErrorCodeException e) {
            return ResultDTO.fail(e);
        } catch (Exception e) {
            return ResultDTO.fail(CommonErrorCode.UNKOWN_ERROR);
        }
    }


    @RequestMapping("das")
    public String aa(){
        return "sad";
    }
}
