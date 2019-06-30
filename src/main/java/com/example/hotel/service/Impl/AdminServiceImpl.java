package com.example.hotel.service.Impl;

import com.example.hotel.dao.AdminMapper;
import com.example.hotel.dao.UserMapper;
import com.example.hotel.model.Admin;
import com.example.hotel.model.AdminExample;
import com.example.hotel.service.AdminService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("AdminService")
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public long countByExample(AdminExample example) {
        return 0;
    }

    @Override
    public int deleteByExample(AdminExample example) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(Integer adminId) {
        return 0;
    }

    @Override
    public int insert(Admin record) {
        return 0;
    }

    @Override
    public int insertSelective(Admin record) {
        return 0;
    }

    @Override
    public List<Admin> selectByExampleWithRowbounds(AdminExample example, RowBounds rowBounds) {
        return null;
    }

    @Override
    public List<Admin> selectByExample(AdminExample example) {
        return null;
    }

    @Override
    public Admin selectByPrimaryKey(Integer adminId) {
        return null;
    }

    @Override
    public int updateByExampleSelective(Admin record, AdminExample example) {
        return 0;
    }

    @Override
    public int updateByExample(Admin record, AdminExample example) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(Admin record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Admin record) {
        return 0;
    }

    @Override
    public Admin selectByUname(String uname) {
        return this.adminMapper.selectByUname(uname);
    }

}
