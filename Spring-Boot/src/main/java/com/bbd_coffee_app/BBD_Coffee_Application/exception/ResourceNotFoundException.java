package com.bbd_coffee_app.BBD_Coffee_Application.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException {
  private String message;
    public ResourceNotFoundException(String message) {
        super(message);
        this.message=message;
    }
}
