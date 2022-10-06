package com.api.auth.dtos;


import lombok.Getter;

@Getter
public class UserLogin {
    private String username, password;
}