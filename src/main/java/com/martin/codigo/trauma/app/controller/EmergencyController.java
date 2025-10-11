package com.martin.codigo.trauma.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.martin.codigo.trauma.app.entities.Emergency;
import com.martin.codigo.trauma.app.models.EmergencyDto;
import com.martin.codigo.trauma.app.services.EmergencyService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/emergencies")
public class EmergencyController {


    @Autowired
    private EmergencyService emergencyService;

    @GetMapping
    public List<Emergency> findAll(){
        return emergencyService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody EmergencyDto emergencyDto, BindingResult result){

        if(result.hasErrors()){
            return validation(result);
        }

        Emergency emergencyCreated = emergencyService.save(emergencyDto);

        return ResponseEntity.status(HttpStatus.CREATED.value()).body(emergencyCreated);
    }

    private ResponseEntity<?> validation(BindingResult result) {
        Map<String, Object> errosMap = new HashMap<>();

        // llenar el diccionario con todos los errores
        result.getFieldErrors().forEach(error -> {
            errosMap.put(error.getField(), "El campo " + error.getField() + " es invalido!");
        });

        return ResponseEntity.badRequest().body(errosMap);
    }



}
