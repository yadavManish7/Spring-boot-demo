package com.uta.employees.exception;

import lombok.Getter;

public class EmployeeNotFoundException extends RuntimeException{

    private String message;

    @Getter
    private int code;

    public EmployeeNotFoundException(String message , int code){
        super(message);

        this.message=message;
        this.code=code;
    }
}
