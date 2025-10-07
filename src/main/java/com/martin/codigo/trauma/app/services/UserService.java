package com.martin.codigo.trauma.app.services;

import java.util.List;

import com.martin.codigo.trauma.app.entities.User;

public interface UserService {

    List<User> findAll();
    User save(User user);
    

}
