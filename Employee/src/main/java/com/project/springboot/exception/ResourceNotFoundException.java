package com.project.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)   //can be used in REST API, better to use separately
public class ResourceNotFoundException extends RuntimeException{


    public ResourceNotFoundException(String message){
        super(message);

    }
}
//whenever our REST API throw above exception, it should return a message to the client with status code not found