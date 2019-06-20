package com.example.hotel.DTO;

import lombok.Data;

/**
 * Created by codedrinker on 2018/11/25.
 */
@Data
public class TokenDTO {
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}