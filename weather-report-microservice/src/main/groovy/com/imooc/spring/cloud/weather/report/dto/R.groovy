package com.imooc.spring.cloud.weather.report.dto
/**
 * @author linyicong* @since 2019-06-07
 */
class R<T> {
    private static final int SUCCESS_CODE = 200
    private static final int FAILED_CODE = 500
    private static final String SUCCESS_MESSAGE = "success"
    private static final String FAILED_MESSAGE = "failed"

    int code
    String message
    T data

    static <T> R<T> success(T data) {
        return new R<T>(
                code: SUCCESS_CODE,
                message: SUCCESS_MESSAGE,
                data: data
        )
    }

    static <T> R<T> failed(T data) {
        return new R<T>(
                code: FAILED_CODE,
                message: FAILED_MESSAGE,
                data: data
        )
    }

    static <T> R<T> failed(String message, T data) {
        return new R<T>(
                code: FAILED_CODE,
                message: message,
                data: data
        )
    }
}
