package com.martin.codigo.trauma.app.services;

import java.util.List;

import com.martin.codigo.trauma.app.entities.Emergency;
import com.martin.codigo.trauma.app.models.EmergencyDto;

public interface EmergencyService {

    List<Emergency> findAll();

    Emergency save(EmergencyDto emergencyDto);

}
