package com.martin.codigo.trauma.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.martin.codigo.trauma.app.entities.Emergency;
import com.martin.codigo.trauma.app.entities.User;
import com.martin.codigo.trauma.app.entities.UsersEmergencies;
import com.martin.codigo.trauma.app.models.EmergencyDto;
import com.martin.codigo.trauma.app.repositories.EmergencyRepository;
import com.martin.codigo.trauma.app.repositories.UsersEmergencyRepository;

@Service
public class EmergencyServiceImpl implements EmergencyService {

    @Autowired
    private EmergencyRepository emergencyRepository;

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

        Emergency emergencyCreated = emergencyRepository.save(emergencyDto.getEmergency());
        User userAssigned = emergencyDto.getUserAssigned();
        User createdBy = emergencyDto.getCreatedBy();

        UsersEmergencies usersEmergencies = new UsersEmergencies(userAssigned, emergencyCreated, createdBy,
                emergencyDto.getEmergencyRole());

        usersEmergencyRepository.save(usersEmergencies);

        return emergencyCreated;
    }

}
