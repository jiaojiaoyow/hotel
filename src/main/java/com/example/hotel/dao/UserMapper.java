package com.example.hotel.dao;

import java.util.List;

import com.example.hotel.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface UserMapper {


    int insert(User record);

    int insertSelective(User record);


}