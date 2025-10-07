package com.martin.codigo.trauma.app.repositories;

import org.springframework.data.repository.CrudRepository;

import com.martin.codigo.trauma.app.entities.UsersEmergencies;

public interface UsersEmergencyRepository extends CrudRepository<UsersEmergencies,Long> {

}
