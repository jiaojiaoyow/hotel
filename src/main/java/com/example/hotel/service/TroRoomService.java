package com.example.hotel.service;

import com.example.hotel.model.TroRoom;
import com.example.hotel.model.TroRoomExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface TroRoomService {
    long countByExample(TroRoomExample example);

    int deleteByExample(TroRoomExample example);

    int deleteByPrimaryKey(String roomintroduce);

    int insert(TroRoom record);

    int insertSelective(TroRoom record);

    List<TroRoom> selectByExampleWithRowbounds(TroRoomExample example, RowBounds rowBounds);

    List<TroRoom> selectByExample(TroRoomExample example);

    TroRoom selectByPrimaryKey(String roomintroduce);

    int updateByExampleSelective(@Param("record") TroRoom record, @Param("example") TroRoomExample example);

    int updateByExample(@Param("record") TroRoom record, @Param("example") TroRoomExample example);

    int updateByPrimaryKeySelective(TroRoom record);

    int updateByPrimaryKey(TroRoom record);

    List<TroRoom> selectAllTroRoom();
}
