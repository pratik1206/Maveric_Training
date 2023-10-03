package com.kuka.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

public class DuplicateDataException extends RuntimeException{
    public DuplicateDataException(String msg){
        super(msg);
    }

    @RestControllerAdvice
    public static class CentralizedExceptionHandler {
        @ResponseStatus(value= HttpStatus.BAD_REQUEST)
        @ExceptionHandler(ConstraintViolationException.class)
        public Map<String,String> handleBadRequest(MethodArgumentNotValidException e) {
                Map<String,String> errorMap =new HashMap();
                e.getBindingResult().getFieldErrors().forEach(error->{
                    errorMap.put(error.getField(),error.getDefaultMessage());

                });


            return errorMap;
        }
    }
}
