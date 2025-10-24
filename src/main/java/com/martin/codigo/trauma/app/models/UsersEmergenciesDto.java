package com.martin.codigo.trauma.app.models;

import java.time.LocalDateTime;

public class UsersEmergenciesDto {

    private LocalDateTime assignedAt;
    private String assignedBy;
    private LocalDateTime completedAt;
    private String emergencyName;
    private LocalDateTime startedAt;
    private String userAssigned;
    private String notes;
    private String emergencyRole;
    private String status;

    public UsersEmergenciesDto() {
    }

    public UsersEmergenciesDto(LocalDateTime assignedAt, String assignedBy, LocalDateTime completedAt,
            String emergencyName, LocalDateTime startedAt, String userAssigned, String notes, String emergencyRole,
            String status) {
        this.assignedAt = assignedAt;
        this.assignedBy = assignedBy;
        this.completedAt = completedAt;
        this.emergencyName = emergencyName;
        this.startedAt = startedAt;
        this.userAssigned = userAssigned;
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

    public LocalDateTime getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(LocalDateTime startedAt) {
        this.startedAt = startedAt;
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
        return emergencyRole;
    }

    public void setEmergencyRole(String emergencyRole) {
        this.emergencyRole = emergencyRole;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
