package com.example.hotel.DTO;

public class cOrderDTO {

    private String uid;  //用户id
    private int orderid; //订单id
    private int status; //状态 1
    private double balance;  //余额

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }



    public  cOrderDTO(){}

    public cOrderDTO(String uid,int orderid,int status,double balance){

        this.orderid=orderid;
        this.uid=uid;
        this.status=status;
        this.balance=balance;
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

}

