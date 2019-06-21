package com.example.hotel.service.Impl;

import com.example.hotel.dao.UserMapper;
import com.example.hotel.model.User;
import com.example.hotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("UserService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public int insert(User record) {
        return userMapper.insert(record);
    }

    @Override
    public int insertSelective(User record) {
        return this.userMapper.insertSelective(record);
    }
}
