package com.martin.codigo.trauma.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.martin.codigo.trauma.app.entities.UsersEmergencies;
import com.martin.codigo.trauma.app.services.UsersEmergenciesService;

@RestController
@RequestMapping("/api/users-emergencies")
public class UsersEmergenciesController {

    @Autowired
    private UsersEmergenciesService service;

    @GetMapping
    public List<UsersEmergencies> findAll() {
        return service.findAll();
    }

}
