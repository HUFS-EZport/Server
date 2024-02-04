package com.example.ezports.global.exception;

import com.example.ezports.global.common.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GeneralExceptionHandler {

    @ExceptionHandler(value = { GeneralException.class})
    protected ApiResponse handleCustomException(GeneralException e) {
        log.error("handleCustomException throw CustomException : {}", e.getErrorCode());
        return ApiResponse.onFailure(e.getErrorCode(), "");
    }
}