package com.example.hotel.interceptor;

import com.alibaba.fastjson.JSON;

import com.example.hotel.DTO.ResultDTO;
import com.example.hotel.error.CommonErrorCode;
import com.example.hotel.model.User;
import com.example.hotel.service.UserService;
import com.example.hotel.session.SessionUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

/**
 * Created by codedrinker on 2018/12/2.
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

//    @Autowired
//    private UserService userService;
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        String url = request.getRequestURI();
//        if(url.indexOf("/api/login")>=0){
//            return true;
//        }
//        //获取session
//        HttpSession session = request.getSession();
//
//        U
//
//    }
}
