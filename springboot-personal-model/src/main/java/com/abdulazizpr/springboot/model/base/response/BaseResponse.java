package com.abdulazizpr.springboot.model.base.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse<T> {
    private int code;
    private String message;
    private List<String> errors;
    private T data;

    //Constructor with Data
    public BaseResponse(int code, String message, T data) {
        this(code, message, null, data);
    }

    //Constructor with Errors
    public BaseResponse(int code, String message, List<String> errors) {
        this(code, message, errors, null);
    }

    //Constructor only with code and message
    public BaseResponse(int code, String message) {
        this(code, message, null, null);
    }
}
