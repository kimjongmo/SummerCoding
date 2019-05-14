package com.todo.common.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
@Getter
@AllArgsConstructor
public class ValidCustomException extends RuntimeException{
    private Error[] errors;

    public ValidCustomException(String defaultMessage, String field){
        this.errors = new Error[]{new Error(defaultMessage,field)};
    }

    @Getter
    @AllArgsConstructor
    class Error{
        private String defaultMessage;
        private String field;
    }
}
