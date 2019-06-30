package com.example.hotel.dao;

import com.example.hotel.model.Company;
import com.example.hotel.model.CompanyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface CompanyMapper {
    long countByExample(CompanyExample example);

    int deleteByExample(CompanyExample example);

    int insert(Company record);

    int insertSelective(Company record);

    List<Company> selectByExampleWithRowbounds(CompanyExample example, RowBounds rowBounds);

    List<Company> selectByExample(CompanyExample example);

    int updateByExampleSelective(@Param("record") Company record, @Param("example") CompanyExample example);

    int updateByExample(@Param("record") Company record, @Param("example") CompanyExample example);

    Company selectAll();
}