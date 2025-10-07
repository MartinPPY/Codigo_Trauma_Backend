package com.martin.codigo.trauma.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.martin.codigo.trauma.app.entities.Emergency;
import com.martin.codigo.trauma.app.models.EmergencyDto;
import com.martin.codigo.trauma.app.services.EmergencyService;


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
    public ResponseEntity<?> create( @RequestBody EmergencyDto emergencyDto){

        Emergency emergencyCreated = emergencyService.save(emergencyDto);

        return ResponseEntity.status(HttpStatus.CREATED.value()).body(emergencyCreated);
    }



}
