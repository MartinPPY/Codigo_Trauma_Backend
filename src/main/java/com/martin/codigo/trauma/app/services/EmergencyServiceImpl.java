package com.martin.codigo.trauma.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.martin.codigo.trauma.app.entities.Emergency;
import com.martin.codigo.trauma.app.entities.User;
import com.martin.codigo.trauma.app.entities.UsersEmergencies;
import com.martin.codigo.trauma.app.models.EmergencyDto;
import com.martin.codigo.trauma.app.repositories.EmergencyRepository;
import com.martin.codigo.trauma.app.repositories.UserRepository;
import com.martin.codigo.trauma.app.repositories.UsersEmergencyRepository;

@Service
public class EmergencyServiceImpl implements EmergencyService {

    @Autowired
    private EmergencyRepository emergencyRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UsersEmergencyRepository usersEmergencyRepository;

    @Transactional
    @Override
    public List<Emergency> findAll() {
        return (List<Emergency>) emergencyRepository.findAll();
    }

    @Transactional
    @Override
    public Emergency save(EmergencyDto emergencyDto) {

        Emergency emergency = emergencyDto.getEmergency();
        Optional<User> userAssignedDb = userRepository.findByUsername(emergencyDto.getUserAssigned().getUsername());
        Optional<User> createdByDb = userRepository.findByUsername(emergencyDto.getCreatedBy().getUsername());

        /*
         * Validar que el usuario created by existe y sea un administrador o
         * recepcionista
         */
        if (!createdByDb.isPresent()) {
            throw new NullPointerException("El creador de la emergencia no existe!");
        }

        if (createdByDb.orElseThrow().getRole().getId().equals(2L)) {
            throw new NullPointerException("Tu rol no puede asignar crear emergencias!");
        }

        /* Validar que el usuario asignado sea medico y que existe */
        if (!userAssignedDb.isPresent()) {
            throw new NullPointerException("El medico no existe!");
        }

        if (userAssignedDb.orElseThrow().getRole().getId().equals(1L)
                || userAssignedDb.orElseThrow().getRole().getId().equals(3L)) {
            throw new NullPointerException(
                    "El usuario asignado posee un rol que no es capaz de abordar una emergencia!");
        }

        /* Setear usuarios guardados en la base de datos */
        emergency.setCreatedBy(createdByDb.orElseThrow());
        Emergency emergencyCreated = emergencyRepository.save(emergency);

        UsersEmergencies usersEmergencies = new UsersEmergencies(userAssignedDb.orElseThrow(), emergencyCreated,
                createdByDb.orElseThrow(),
                emergencyDto.getEmergencyRole());

        usersEmergencyRepository.save(usersEmergencies);

        userAssignedDb.orElseThrow().setAvaliable(false);
        userRepository.save(userAssignedDb.orElseThrow());
        return emergencyCreated;
    }

}
