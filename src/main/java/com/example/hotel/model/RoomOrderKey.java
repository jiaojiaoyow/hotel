package com.example.hotel.model;

public class RoomOrderKey {
    private Integer orderid;

    private String uid;

    private String roomname;

    public RoomOrderKey(){}

    public RoomOrderKey(Integer orderid,String uid,String roomname){
        this.orderid=orderid;
        this.uid=uid;
        this.roomname=roomname;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public String getRoomname() {
        return roomname;
    }

    public void setRoomname(String roomname) {
        this.roomname = roomname == null ? null : roomname.trim();
    }
}