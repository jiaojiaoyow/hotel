package com.example.hotel.service;

import com.example.hotel.model.User;
import org.springframework.stereotype.Service;

/**
 * Created by codedrinker on 2018/11/29.
 */

public interface UserService {
    int insert(User record);

    int insertSelective(User record);

}
