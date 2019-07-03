package com.example.hotel.dao;

import com.example.hotel.model.RoomOrder;
import com.example.hotel.model.RoomOrderExample;
import com.example.hotel.model.RoomOrderKey;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface RoomOrderMapper {
    long countByExample(RoomOrderExample example);

    int deleteByExample(RoomOrderExample example);

    int deleteByPrimaryKey(RoomOrderKey key);

    int insert(RoomOrder record);

    int insertSelective(RoomOrder record);

    List<RoomOrder> selectByExampleWithBLOBsWithRowbounds(RoomOrderExample example, RowBounds rowBounds);

    List<RoomOrder> selectByExampleWithBLOBs(RoomOrderExample example);

    List<RoomOrder> selectByExampleWithRowbounds(RoomOrderExample example, RowBounds rowBounds);

    List<RoomOrder> selectByExample(RoomOrderExample example);

    RoomOrder selectByPrimaryKey(RoomOrderKey key);

    int updateByExampleSelective(@Param("record") RoomOrder record, @Param("example") RoomOrderExample example);

    int updateByExampleWithBLOBs(@Param("record") RoomOrder record, @Param("example") RoomOrderExample example);

    int updateByExample(@Param("record") RoomOrder record, @Param("example") RoomOrderExample example);

    int updateByPrimaryKeySelective(RoomOrder record);

    int updateByPrimaryKeyWithBLOBs(RoomOrder record);

    int updateByPrimaryKey(RoomOrder record);

    //自己添加的

    List <RoomOrder> selectByUserid(String uid);

   String selectByRDU(RoomOrder record);

    RoomOrder selectByOrderid(String  orderid);

<<<<<<< HEAD
    List<RoomOrder> selectAllCompleteOrder(Map map);
=======

    int selectCount();

    List<RoomOrder> selectPage(Map map);

    List<RoomOrder> selectAllCompleteOrder();
>>>>>>> master

    List<RoomOrder> selectAllOrder(Map map);

    List<RoomOrder> selectAllPayOrder();

<<<<<<< HEAD
    int selectCount();
=======
>>>>>>> master
}