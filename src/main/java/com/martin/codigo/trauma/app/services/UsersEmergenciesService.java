package com.martin.codigo.trauma.app.services;

import java.util.List;

import com.martin.codigo.trauma.app.entities.UsersEmergencies;
import com.martin.codigo.trauma.app.models.UsersEmergenciesDto;

public interface UsersEmergenciesService {

    List<UsersEmergenciesDto> findAllDtos();

    UsersEmergencies save(UsersEmergenciesDto usersEmergenciesDtousersEmergencies);

}
