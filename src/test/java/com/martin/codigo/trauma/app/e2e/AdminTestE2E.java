package com.martin.codigo.trauma.app.e2e;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

//import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootTest
@AutoConfigureMockMvc
public class AdminTestE2E {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void loginAndViewEmergencies() throws Exception {

        //LOGIN EXITOSO
        Map<String, Object> reqBody = new HashMap<>();
        reqBody.put("username", "Martin Romero_bc875e");
        reqBody.put("password", "12345");

        ResultActions response = mockMvc.perform(post("/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(reqBody)));

        response.andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.token").exists())
                .andExpect(jsonPath("$.role").exists())
                .andExpect(jsonPath("$.username").exists())
                .andExpect(jsonPath("$.message").exists());                    
        //COLOCAR TOKEN DE AUTENTICACION Y VER EMERGENCIAS (FILTRAR POR VARIOS ATRIBUTOS)


        //CREAR EMERGENCIAS

        //ACTUALIZAR EMERGENCIA

        //ELIMINAR EMERGENCIAS

        //VER USUARIOS (MEDICOS, ADMINISTRADORES Y RECEPCIONISTAS) CON FILTROS INCLUIDOS

        //AGREGAR USUARIO

        //ELIMINAR USUARIO

    }

}
