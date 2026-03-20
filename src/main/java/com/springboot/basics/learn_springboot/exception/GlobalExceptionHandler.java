package com.springboot.basics.learn_springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.springboot.basics.learn_springboot.payload.ApiResponse;

@ControllerAdvice
public class GlobalExceptionHandler{

    //Handler for Validation Errors
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){

        String message = ex.getBindingResult()
                         .getFieldError()
                         .getDefaultMessage();
        ApiResponse response = new ApiResponse(message,false);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    //Handler for Resource not found
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFoundException ex){
        String message = ex.getMessage();
        ApiResponse response = new ApiResponse(message,false);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}