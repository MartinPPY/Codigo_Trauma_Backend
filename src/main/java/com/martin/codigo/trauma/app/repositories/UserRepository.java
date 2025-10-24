package com.martin.codigo.trauma.app.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.martin.codigo.trauma.app.entities.User;
import com.martin.codigo.trauma.app.models.UserDto;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByUsername(String username);

    @Query("SELECT new com.martin.codigo.trauma.app.models.UserDto(CONCAT(u.name , ' ',u.lastname) , u.email, u.phone, u.role.name, u.available ) FROM User u")
    List<UserDto> findAllUsersDto();

    @Query("SELECT new com.martin.codigo.trauma.app.models.UserDto(CONCAT(u.name , ' ',u.lastname) , u.email, u.phone, u.role.name, u.available ) FROM User u WHERE u.role.id = :id")
    List<UserDto> findAllUserDtoByRole(@Param("id") Long id);

    @Query("SELECT new com.martin.codigo.trauma.app.models.UserDto(CONCAT(u.name , ' ',u.lastname) , u.email, u.phone, u.role.name, u.available ) FROM User u WHERE u.available = :availability")
    List<UserDto> findAllUserDtoByAvailability(@Param("availability") Boolean availability);

    @Query("SELECT new com.martin.codigo.trauma.app.models.UserDto(CONCAT(u.name , ' ',u.lastname), u.email, u.phone, u.role.name, u.available ) FROM User u WHERE u.role.id = :id  AND u.available = :availability")
    List<UserDto> findAllUserDtoByAvailabilityAndRoleId(@Param("id") Long id,
            @Param("availability") Boolean availability);

}
