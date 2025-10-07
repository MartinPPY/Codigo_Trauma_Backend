package com.martin.codigo.trauma.app.helpers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

@ControllerAdvice
public class GlobalExceptionHandler  {

    @ExceptionHandler(InvalidFormatException.class)
    public ResponseEntity<?>handleRoleIdentificationException(InvalidFormatException ex){

        System.out.println(ex.getClass());
        
        Map<String,Object> response = new HashMap<>();
        response.put("message", "el rol ingresado no existe o no es valido!");
        return ResponseEntity.badRequest().body(response);
    }

}
