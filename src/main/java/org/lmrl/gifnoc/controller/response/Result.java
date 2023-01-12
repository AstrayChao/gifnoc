package org.lmrl.gifnoc.controller.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.lmrl.gifnoc.common.enums.ResultInfo;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record Result<T>(int code, String message, T data) {

    public static <T> Result<T> success(T data) {
        return success(null, data);
    }

    public static <T> Result<T> success(String message, T data) {
        return new Result<>(200, message, data);
    }

    public static <T> Result<T> fail(int code, String message) {
        return fail(code, message, null);
    }

    public static <T> Result<T> fail(int code, String message, T data) {
        return new Result<>(code, message, data);
    }

    public static <T> Result<T> fail(ResultInfo resultInfo, T data) {
        return new Result<>(resultInfo.code, resultInfo.message, data);
    }
}
