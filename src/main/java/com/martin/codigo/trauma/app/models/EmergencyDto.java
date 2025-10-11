package com.martin.codigo.trauma.app.models;

import com.martin.codigo.trauma.app.entities.Emergency;
import com.martin.codigo.trauma.app.entities.User;

import jakarta.validation.constraints.NotNull;

public class EmergencyDto {

    @NotNull
    private Emergency emergency;

    @NotNull
    private User createdBy;

    @NotNull
    private User userAssigned;

    @NotNull
    private EmergencyRole emergencyRole;

    public EmergencyDto(Emergency emergency, User createdBy, User userAssigned, EmergencyRole emergencyRole) {
        this.emergency = emergency;
        this.createdBy = createdBy;
        this.userAssigned = userAssigned;
        this.emergencyRole = emergencyRole;
    }

    public Emergency getEmergency() {
        return emergency;
    }

    public void setEmergency(Emergency emergency) {
        this.emergency = emergency;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public User getUserAssigned() {
        return userAssigned;
    }

    public void setUserAssigned(User userAssigned) {
        this.userAssigned = userAssigned;
    }

    public EmergencyRole getEmergencyRole() {
        return emergencyRole;
    }

    public void setEmergencyRole(EmergencyRole emergencyRole) {
        this.emergencyRole = emergencyRole;
    }

    

}
