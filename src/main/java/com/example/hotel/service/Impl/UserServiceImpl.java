package com.example.hotel.service.Impl;

import com.example.hotel.dao.UserMapper;
import com.example.hotel.model.User;
import com.example.hotel.model.UserExample;
import com.example.hotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public void saveOrUpdate(User user) {
        UserExample example = new UserExample();
        example.createCriteria().andUidEqualTo(user.getUid());
        List<User> users = userMapper.selectByExample(example);
        // 先查看是否有，如果有更新，没有创建
        if (users != null && users.size() != 0) {
            user.setGmtModified(System.currentTimeMillis());
            userMapper.updateByExampleSelective(user, example);
        } else {
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(System.currentTimeMillis());
            userMapper.insert(user);
        }
    }

    public User getByToken(String token) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andTokenEqualTo(token);
        List<User> users = userMapper.selectByExample(userExample);
        if (users != null && users.size() != 0) {
            return users.get(0);
        }
        return null;
    }
}
