package com.api.auth.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
@Getter
public class ResourceAlredyExistsException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String resourceName;
    private String fieldName;
    private Object fieldValue;

    public ResourceAlredyExistsException( String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s with %s '%s' already exists", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}