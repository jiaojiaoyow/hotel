package com.example.hotel.dao;

import com.example.hotel.model.Essay;
import com.example.hotel.model.EssayExample;
import com.example.hotel.model.EssayWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface EssayMapper {
    long countByExample(EssayExample example);

    int deleteByExample(EssayExample example);

    int deleteByPrimaryKey(Integer aid);

    int insert(EssayWithBLOBs record);

    int insertSelective(EssayWithBLOBs record);

    List<EssayWithBLOBs> selectByExampleWithBLOBsWithRowbounds(EssayExample example, RowBounds rowBounds);

    List<EssayWithBLOBs> selectByExampleWithBLOBs(EssayExample example);

    List<Essay> selectByExampleWithRowbounds(EssayExample example, RowBounds rowBounds);

    List<Essay> selectByExample(EssayExample example);

    EssayWithBLOBs selectByPrimaryKey(Integer aid);

    int updateByExampleSelective(@Param("record") EssayWithBLOBs record, @Param("example") EssayExample example);

    int updateByExampleWithBLOBs(@Param("record") EssayWithBLOBs record, @Param("example") EssayExample example);

    int updateByExample(@Param("record") Essay record, @Param("example") EssayExample example);

    int updateByPrimaryKeySelective(EssayWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(EssayWithBLOBs record);

    int updateByPrimaryKey(Essay record);
//    自己加的
    List<Essay> selectAll();



}