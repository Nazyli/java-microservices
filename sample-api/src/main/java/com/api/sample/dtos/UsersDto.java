package com.api.sample.dtos;


import lombok.Data;
@Data
public class UsersDto {
	private String userId;
	private String userName;
	private String userPassword;
	private String scope;
	private boolean isActives;
}
