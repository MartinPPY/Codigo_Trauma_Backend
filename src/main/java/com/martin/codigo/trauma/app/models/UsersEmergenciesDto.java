package com.martin.codigo.trauma.app.models;

import java.time.LocalDateTime;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class UsersEmergenciesDto {

    private Long id;
    private LocalDateTime assignedAt;
    private String assignedBy;
    private LocalDateTime completedAt;
    private String emergencyName;
    private String userAssigned;
    private String notes;

    @Enumerated(EnumType.STRING)
    private EmergencyRole emergencyRole;

    @Enumerated(EnumType.STRING)
    private EmergencyStatus status;

    public UsersEmergenciesDto() {
    }

    public UsersEmergenciesDto(Long id,LocalDateTime assignedAt, String assignedBy, LocalDateTime completedAt,
            String emergencyName, String userAssigned, String notes,
            EmergencyRole emergencyRole,
            EmergencyStatus status) {
        this.id = id;
        this.assignedAt = assignedAt;
        this.assignedBy = assignedBy; // Nombre de la persona que lo asigno
        this.completedAt = completedAt;
        this.emergencyName = emergencyName; // nombre de la emergencia (de la tabla emergencias)
        this.userAssigned = userAssigned; // usuario asignado
        this.notes = notes;
        this.emergencyRole = emergencyRole;
        this.status = status;
    }

    public LocalDateTime getAssignedAt() {
        return assignedAt;
    }

    public void setAssignedAt(LocalDateTime assignedAt) {
        this.assignedAt = assignedAt;
    }

    public String getAssignedBy() {
        return assignedBy;
    }

    public void setAssignedBy(String assignedBy) {
        this.assignedBy = assignedBy;
    }

    public LocalDateTime getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(LocalDateTime completedAt) {
        this.completedAt = completedAt;
    }

    public String getEmergencyName() {
        return emergencyName;
    }

    public void setEmergencyName(String emergencyName) {
        this.emergencyName = emergencyName;
    }

    public String getUserAssigned() {
        return userAssigned;
    }

    public void setUserAssigned(String userAssigned) {
        this.userAssigned = userAssigned;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getEmergencyRole() {
        return emergencyRole.toString();
    }

    public void setEmergencyRole(EmergencyRole emergencyRole) {
        this.emergencyRole = emergencyRole;
    }

    public String getStatus() {
        return status.toString();
    }

    public void setStatus(EmergencyStatus status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    

}
