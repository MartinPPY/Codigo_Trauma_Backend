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

import com.martin.codigo.trauma.app.entities.User;
import com.martin.codigo.trauma.app.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> findALl() {
        return (List<User>) userService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody User user, BindingResult result) {
        if(result.hasErrors()){
            return validation(result);
        }

        User userCreated = userService.save(user);

        Map<String,Object> response = new HashMap<>();
        response.put("message", "Usuario creado!");
        response.put("user", userCreated);

        return ResponseEntity.status(HttpStatus.CREATED.value()).body(response);
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
