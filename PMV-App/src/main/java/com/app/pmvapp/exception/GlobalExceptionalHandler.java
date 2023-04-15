package com.app.pmvapp.exception;

import com.app.pmvapp.model.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionalHandler {

    @ExceptionHandler(ResourceNotFound.class)
    public ApiResponse generateApiResponse(ResourceNotFound ex){
        return ApiResponse.builder().message(ex.getMessage()).success(false).status(HttpStatus.NOT_FOUND).build();
    }
}
