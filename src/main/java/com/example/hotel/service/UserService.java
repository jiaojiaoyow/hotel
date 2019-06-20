package com.example.hotel.service;

import com.example.hotel.dao.UserMapper;
import com.example.hotel.model.User;
import com.example.hotel.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by codedrinker on 2018/11/29.
 */
@Service
public interface UserService {
    public void saveOrUpdate(User user);
    public User getByToken(String token);

}
