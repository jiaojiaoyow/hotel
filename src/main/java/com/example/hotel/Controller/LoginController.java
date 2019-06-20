package com.example.hotel.Controller;

import com.example.hotel.DTO.LoginDTO;
import com.example.hotel.DTO.ResultDTO;
import com.example.hotel.DTO.SessionDTO;
import com.example.hotel.DTO.TokenDTO;
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
import java.util.UUID;

/**
 * 不要在意get和set方法的
 */
@RestController
public class LoginController {
    @Autowired
    private WechatAdapter wechatAdapter;

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public ResultDTO login(@RequestBody LoginDTO loginDTO){
        try{

            //使用code调用微信api来获取openid和
            SessionDTO sessionDTO=wechatAdapter.jscode2session(loginDTO.getCode());
            //检验传递过来的用户信息是否合法
            DigestUtil.checkDigest(loginDTO.getRawData(),sessionDTO.getSessionKey(),loginDTO.getSignature());
            //使用uuid为用户随机生成一个凭证
            String token = UUID.randomUUID().toString();

            //保存微信来的数据
            User user=JSON.parseObject(loginDTO.getRawData(),User.class);
            user.setToken(token);
            user.setUid(sessionDTO.getOpenid());
            userService.saveOrUpdate(user);
            //生成token，用于自定义登录态，这里的存储逻辑比较复杂，放到下一讲
            TokenDTO data = new TokenDTO();
            data.setToken(token);
            return ResultDTO.ok(data);
        }catch (ErrorCodeException e) {
            return ResultDTO.fail(e);
        } catch (Exception e) {
            return ResultDTO.fail(CommonErrorCode.UNKOWN_ERROR);
        }
    }

}
