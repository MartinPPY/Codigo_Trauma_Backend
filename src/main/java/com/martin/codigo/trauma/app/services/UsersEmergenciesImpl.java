package com.martin.codigo.trauma.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.martin.codigo.trauma.app.entities.UsersEmergencies;
import com.martin.codigo.trauma.app.models.UsersEmergenciesDto;
import com.martin.codigo.trauma.app.repositories.UsersEmergencyRepository;

@Service
public class UsersEmergenciesImpl implements UsersEmergenciesService {

    @Autowired
    private UsersEmergencyRepository usersEmergencyRepository;

    @Transactional
    @Override
    public List<UsersEmergenciesDto> findAllDtos() {
        return usersEmergencyRepository.findAllDto();
    }

    @Transactional
    @Override
    public UsersEmergencies save(UsersEmergenciesDto usersEmergenciesDto) {

        /* Validar que existe por el id */
        Optional<UsersEmergencies> usersEmergenciesDb = usersEmergencyRepository.findById(usersEmergenciesDto.getId());
        if (!usersEmergenciesDb.isPresent()) {
            throw new NullPointerException("Emergencia no encontrada!");
        }

        usersEmergenciesDb.orElseThrow().setNotes(usersEmergenciesDto.getNotes());

        return usersEmergencyRepository.save(usersEmergenciesDb.orElseThrow());
    }

}
