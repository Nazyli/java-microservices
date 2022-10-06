package com.api.auth.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Data
public class JwtToken {
    public String authorization;
    private String tokenType;
    private String scope;
    private long expiresIn;
}
