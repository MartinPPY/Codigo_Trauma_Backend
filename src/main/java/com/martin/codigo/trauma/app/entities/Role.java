package com.martin.codigo.trauma.app.entities;

import com.martin.codigo.trauma.app.models.UserRoles;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Enumerated(EnumType.STRING)
    private UserRoles name;

    public Role(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserRoles getName() {
        return name;
    }

    public void setName(UserRoles name) {
        this.name = name;
    }
    

}
