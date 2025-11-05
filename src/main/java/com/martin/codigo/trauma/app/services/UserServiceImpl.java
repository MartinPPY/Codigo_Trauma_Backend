package com.martin.codigo.trauma.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.martin.codigo.trauma.app.entities.Role;
import com.martin.codigo.trauma.app.entities.User;
import com.martin.codigo.trauma.app.models.UserDto;
import com.martin.codigo.trauma.app.repositories.RoleRepository;
import com.martin.codigo.trauma.app.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public List<UserDto> findAllUserDtoByAvailabilityAndRoleId(Long id, Boolean availability) {

        if (id == null && availability == null) {

            System.out.println("todo es nulo");
            userRepository.findAllUsersDto();

        } else if (id == null && availability != null) {

            System.out.println("id es nulo");
            return userRepository.findAllUserDtoByAvailability(availability);

        } else if (availability == null && id != null) {

            System.out.println("disponibilidad es nulo");
            return userRepository.findAllUserDtoByRole(id);

        } else {

            System.out.println("id y disponibilidad estan");
            return userRepository.findAllUserDtoByAvailabilityAndRoleId(id, availability);
        }

        System.out.println("id y disponibilidad son nulos");
        return userRepository.findAllUsersDto();

    }

    @Transactional
    @Override
    public User save(User user) {

        Optional<Role> roleDb = roleRepository.findById(user.getRole().getId());

        System.out.println(user.getRole().getId());

        if (!roleDb.isPresent()) {
            throw new IllegalArgumentException("el role ingresado no existe!");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

}
