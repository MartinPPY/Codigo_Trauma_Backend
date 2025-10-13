package com.martin.codigo.trauma.app.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.martin.codigo.trauma.app.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByUsername(String username);

}
