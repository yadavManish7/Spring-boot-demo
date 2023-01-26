package com.uta.employees.exception;

public class EmployeeNotFoundException extends RuntimeException{

    private String message;
    private int code;

    public EmployeeNotFoundException(String message , int code){
        super(message);
        this.message=message;
        this.code=code;
    }
}
