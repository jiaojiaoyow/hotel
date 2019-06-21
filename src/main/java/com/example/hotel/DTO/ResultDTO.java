package com.example.hotel.DTO;

import com.example.hotel.error.IErrorCode;
import lombok.Data;

/**
 * Created by codedrinker on 2018/11/25.
 * 返回登陆成功或者失败等信息
 */
@Data
public class ResultDTO {
    private Integer status;
    private Object data;
    private String message;

    public static ResultDTO ok(Object data) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setStatus(200);
        resultDTO.setData(data);
        resultDTO.setMessage("请求成功");
        try{
            return resultDTO;
        }catch (Exception e){

        }
        System.out.println();
        return resultDTO;
    }

    public static ResultDTO fail(String message) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setStatus(400);
        resultDTO.setMessage(message);
        return resultDTO;
    }

    public static ResultDTO fail(IErrorCode errorCode) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setStatus(errorCode.getCode());
        resultDTO.setMessage(errorCode.getMessage());
        return resultDTO;
    }


}
