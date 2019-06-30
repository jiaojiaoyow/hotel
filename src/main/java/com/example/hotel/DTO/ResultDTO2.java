package com.example.hotel.DTO;

import com.example.hotel.error.IErrorCode;
import lombok.Data;

/**
 * Created by codedrinker on 2018/11/25.
 * 返回登陆成功或者失败等信息
 */


public class ResultDTO2 {
    private Integer status;
    private Object data;
    private String message;

    private TokenDTO token;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public TokenDTO getToken() {
        return token;
    }

    public void setToken(TokenDTO token) {
        this.token = token;
    }

    public static ResultDTO2 ok(Object data,TokenDTO token) {
        ResultDTO2 resultDTO = new ResultDTO2();
        resultDTO.setStatus(200);
        resultDTO.setData(data);
        resultDTO.setMessage("请求成功");
        resultDTO.setToken(token);
        return resultDTO;
    }

    public static ResultDTO2 fail() {
        ResultDTO2 resultDTO = new ResultDTO2();
        resultDTO.setStatus(201);
        resultDTO.setMessage("请求成功，但是没有数据");
        return resultDTO;
    }

    public static ResultDTO2 fail(String message) {
        ResultDTO2 resultDTO = new ResultDTO2();
        resultDTO.setStatus(204);
        resultDTO.setMessage("请求失败，数据库操作失误"+message);
        return resultDTO;
    }

    public static ResultDTO2 unkonwFail(String message) {
        ResultDTO2 resultDTO = new ResultDTO2();
        resultDTO.setStatus(202);
        resultDTO.setMessage("请求失败，因为："+message);
        return resultDTO;
    }


}
