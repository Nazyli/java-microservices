package com.api.auth.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
@Getter
public class UnauthorizedException extends RuntimeException {
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String resourceName;
    private String fieldName;
    private Object fieldValue;

    public UnauthorizedException(Object fieldValue,  String msg) {
        super(String.format("Username : "+ fieldValue + " " +msg));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}