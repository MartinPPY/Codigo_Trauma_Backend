package com.martin.codigo.trauma.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.martin.codigo.trauma.app.entities.UsersEmergencies;
import com.martin.codigo.trauma.app.models.UsersEmergenciesDto;
import com.martin.codigo.trauma.app.services.UsersEmergenciesService;

@RestController
@RequestMapping("/api/users-emergencies")
public class UsersEmergenciesController {

    @Autowired
    private UsersEmergenciesService service;

    @GetMapping
    public List<UsersEmergenciesDto> findAll() {
        return service.findAllDtos();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody UsersEmergenciesDto usersEmergenciesDto,
            BindingResult result) {

        if (result.hasErrors())
            return validation(result);

        UsersEmergencies usersEmergenciesSaved = service.save(usersEmergenciesDto);

        Map<String, Object> res = new HashMap<>();
        res.put("message", "Emergencia Actualizada!");
        res.put("emergency", usersEmergenciesSaved);

        return ResponseEntity.ok().body(res);
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
