package com.martin.codigo.trauma.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.martin.codigo.trauma.app.entities.Role;
import com.martin.codigo.trauma.app.entities.User;
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

    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User save(User user) {

        Optional<Role> roleDb = roleRepository.findById(user.getRole().getId());

        if (!roleDb.isPresent()) {
            throw new IllegalArgumentException("el role ingresado no existe!");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

}
