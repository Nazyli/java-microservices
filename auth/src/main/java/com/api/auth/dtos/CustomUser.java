package com.api.auth.dtos;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;


@SuppressWarnings("serial")
public class CustomUser extends User {

    private final String userId;
    private final int applicationId;

    public CustomUser(String username, String password,
                      Collection<? extends GrantedAuthority> authorities, String userId, int applicationId) {
        super(username, password, authorities);
        this.userId = userId;
        this.applicationId = applicationId;
      }

	public String getUserId() {
		return userId;
	}
	public int getApplicationId() {
		return applicationId;
	}
	
}