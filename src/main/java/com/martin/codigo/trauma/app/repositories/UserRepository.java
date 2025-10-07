package com.martin.codigo.trauma.app.repositories;

import org.springframework.data.repository.CrudRepository;

import com.martin.codigo.trauma.app.entities.User;

public interface UserRepository extends CrudRepository<User,Long> {

}
