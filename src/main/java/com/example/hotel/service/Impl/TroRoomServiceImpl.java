package com.example.hotel.service.Impl;

import com.example.hotel.dao.TroRoomMapper;
import com.example.hotel.model.TroRoom;
import com.example.hotel.model.TroRoomExample;
import com.example.hotel.service.TroRoomService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("TroRoomService")
public class TroRoomServiceImpl implements TroRoomService {

    @Autowired
    private TroRoomMapper troRoomMapper;

    @Override
    public long countByExample(TroRoomExample example) {
        return 0;
    }

    @Override
    public int deleteByExample(TroRoomExample example) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(String roomintroduce) {
        return 0;
    }

    @Override
    public int insert(TroRoom record) {
        return 0;
    }

    @Override
    public int insertSelective(TroRoom record) {
        return troRoomMapper.insertSelective(record);
    }

    @Override
    public List<TroRoom> selectByExampleWithRowbounds(TroRoomExample example, RowBounds rowBounds) {
        return null;
    }

    @Override
    public List<TroRoom> selectByExample(TroRoomExample example) {
        return null;
    }

    @Override
    public TroRoom selectByPrimaryKey(String roomintroduce) {
        return null;
    }

    @Override
    public int updateByExampleSelective(TroRoom record, TroRoomExample example) {
        return 0;
    }

    @Override
    public int updateByExample(TroRoom record, TroRoomExample example) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(TroRoom record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(TroRoom record) {
        return 0;
    }

    @Override
    public List<TroRoom> selectAllTroRoom() {
        return troRoomMapper.selectAllTroRoom();
    }

    @Override
    public int selectCount() {
        return troRoomMapper.selectCount();
    }
}
