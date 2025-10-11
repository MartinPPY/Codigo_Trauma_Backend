package com.martin.codigo.trauma.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.martin.codigo.trauma.app.entities.UsersEmergencies;
import com.martin.codigo.trauma.app.repositories.UsersEmergencyRepository;

@Service
public class UsersEmergenciesImpl implements UsersEmergenciesService {

    @Autowired
    private UsersEmergencyRepository usersEmergencyRepository;

    @Transactional
    @Override
    public List<UsersEmergencies> findAll() {
        return (List<UsersEmergencies>) usersEmergencyRepository.findAll();
    }

}
