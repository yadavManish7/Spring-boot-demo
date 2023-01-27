package com.uta.employees.controlleradvice;

import com.uta.employees.exception.EmployeeNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;


@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<HashMap<String,Object>>handleEmployeeNotFoundException(EmployeeNotFoundException ex){
        HashMap<String, Object> errorResponseMap = new HashMap<>();
        errorResponseMap.put("status", "error");
        errorResponseMap.put("message", ex.getMessage());
        return ResponseEntity.status(ex.getCode()).body(errorResponseMap);
    }
}
