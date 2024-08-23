package com.diginiq.bigboss.utils.helper;

import com.diginiq.bigboss.model.base.BaseResponse;

public class BaseResponseHelper {
    public static <T> BaseResponse<T> successEmptyData() {
        return new BaseResponse<>(200, "OK", null);
    }

    public static <T> BaseResponse<T> badRequestEmptyData() {
        return new BaseResponse<>(400, "Bad Request", null);
    }

    public static <T> BaseResponse<T> successWithData(T data) {
        return new BaseResponse<>(200, "OK", data);
    }
}
