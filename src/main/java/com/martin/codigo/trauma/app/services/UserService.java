package com.martin.codigo.trauma.app.services;

import java.util.List;

import com.martin.codigo.trauma.app.entities.User;
import com.martin.codigo.trauma.app.models.UserDto;

public interface UserService {

    User save(User user);

    List<UserDto> findAllUserDtoByAvailabilityAndRoleId(Long id, Boolean availability);
    

}
