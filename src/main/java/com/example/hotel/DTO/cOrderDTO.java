package com.example.hotel.DTO;

public class cOrderDTO {

    private String uid;  //用户id
    private int orderid; //订单id
    private String  rname; //房间名字
    private int number; //订房数量
    private int status; //状态 1

    public  cOrderDTO(){}

    public cOrderDTO(String uid,int orderid,String rname,int number,int status){
        this.number=number;
        this.orderid=orderid;
        this.rname=rname;
        this.uid=uid;
        this.status=status;

    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rame) {
        this.rname = rame;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}

