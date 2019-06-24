package com.example.hotel.service.Impl;

import com.example.hotel.dao.RoomMapper;
import com.example.hotel.model.Room;
import com.example.hotel.model.RoomExample;
import com.example.hotel.service.RoomService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("RoomService")
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomMapper roomMapper;

    @Override
    public long countByExample(RoomExample example) {
        return 0;
    }

    @Override
    public int deleteByExample(RoomExample example) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(String roomname) {
        return 0;
    }

    @Override
    public int insert(Room record) {
        return 0;
    }

    @Override
    public int insertSelective(Room record) {
        return  roomMapper.insertSelective(record);
    }

    @Override
    public List<Room> selectByExampleWithRowbounds(RoomExample example, RowBounds rowBounds) {
        return null;
    }

    @Override
    public List<Room> selectByExample(RoomExample example) {
        return null;
    }

    @Override
    public Room selectByPrimaryKey(String roomname) {
        return roomMapper.selectByPrimaryKey(roomname);
    }

    @Override
    public int updateByExampleSelective(Room record, RoomExample example) {
        return 0;
    }

    @Override
    public int updateByExample(Room record, RoomExample example) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(Room record) {
        return roomMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Room record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeyForNum(String rname, int roomnum) {
        return roomMapper.updateByPrimaryKeyForNum(rname,roomnum);
    }

    @Override
    public int updateByPrimaryKeyForReduce(String rname, int roomnum) {
       return roomMapper.updateByPrimaryKeyForReduce(rname,roomnum);
    }
}
