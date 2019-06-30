package com.example.hotel.service.Impl;

import com.example.hotel.dao.CompanyMapper;
import com.example.hotel.model.Company;
import com.example.hotel.model.CompanyExample;
import com.example.hotel.service.CompanyService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CompanyService")
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public long countByExample(CompanyExample example) {
        return 0;
    }

    @Override
    public int deleteByExample(CompanyExample example) {
        return 0;
    }

    @Override
    public int insert(Company record) {
        return 0;
    }

    @Override
    public int insertSelective(Company record) {
        return this.companyMapper.insertSelective(record);
    }

    @Override
    public List<Company> selectByExampleWithRowbounds(CompanyExample example, RowBounds rowBounds) {
        return null;
    }

    @Override
    public List<Company> selectByExample(CompanyExample example) {
        return null;
    }

    @Override
    public int updateByExampleSelective(Company record, CompanyExample example) {
        return 0;
    }

    @Override
    public int updateByExample(Company record, CompanyExample example) {
        return 0;
    }

    @Override
    public Company selectAll() {
        return this.companyMapper.selectAll();
    }
}
