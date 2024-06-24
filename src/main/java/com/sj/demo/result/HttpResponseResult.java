package com.sj.demo.result;

import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class HttpResponseResult<T> {

    private int code;

    private String message;

    private T data;

    public HttpResponseResult() {}

    public HttpResponseResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> HttpResponseResult<T> success(T data) {
        return new HttpResponseResult<>(200, "success", data);
    }

    public static <T> HttpResponseResult<T> success() {
        return new HttpResponseResult<>(200, "success", null);
    }
}
