package com.abdulazizpr.springboot.helper;

import com.abdulazizpr.springboot.model.base.response.BaseResponse;
import org.springframework.http.HttpStatus;

import java.util.List;

public class BaseResponseHelper {
    //HTTP Status 200 - Success
    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse<>(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), data);
    }

    public static <T> BaseResponse<T> success() {
        return success(null);
    }

    //HTTP Status 400
    public static <T> BaseResponse<T> badRequest(List<String> errors) {
        return new BaseResponse<>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), errors);
    }

    public static <T> BaseResponse<T> badRequest() {
        return badRequest(null);
    }

    //HTTP Status 404 - Not Found
    public static <T> BaseResponse<T> notFound(List<String> errors) {
        return new BaseResponse<>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), errors);
    }

    //HTTP Status 500 - Internal Server Error
    public static <T> BaseResponse<T> internalServerError(List<String> errors) {
        return new BaseResponse<>(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), errors);
    }

    public static <T> BaseResponse<T> internalServerError() {
        return internalServerError(null);
    }
}
