package com.martin.codigo.trauma.app.entities;

import java.time.LocalDateTime;


import com.martin.codigo.trauma.app.models.EmergencyRole;
import com.martin.codigo.trauma.app.models.EmergencyStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "users_emergencies")
public class UsersEmergencies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")    
    private User user;

    @ManyToOne
    @JoinColumn(name = "emergency_id")
    private Emergency emergency;

    @Column(name = "assigned_at")
    private LocalDateTime assignedAt;

    @ManyToOne
    @JoinColumn(name = "assigned_by")
    private User assignedBy;

    @Enumerated(EnumType.STRING)
    @Column(name = "role_in_emergency")
    private EmergencyRole emergencyRole;
    
    @Enumerated(EnumType.STRING)
    private EmergencyStatus status;

    @Column(name = "started_at")
    private LocalDateTime startedAt;

    @Column(name = "completed_at")
    private LocalDateTime completedAt;

    @Column(columnDefinition = "TEXT")
    private String notes;

    public UsersEmergencies(){
        this.assignedAt = LocalDateTime.now();
        this.status = EmergencyStatus.PENDING;
        this.startedAt = LocalDateTime.now();
    }

    public UsersEmergencies(User user, Emergency emergency, User assignedBy, EmergencyRole emergencyRole) {
        this();
        this.user = user;
        this.emergency = emergency;
        this.assignedBy = assignedBy;
        this.emergencyRole = emergencyRole;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Emergency getEmergency() {
        return emergency;
    }

    public void setEmergency(Emergency emergency) {
        this.emergency = emergency;
    }

    public LocalDateTime getAssignedAt() {
        return assignedAt;
    }

    public void setAssignedAt(LocalDateTime assignedAt) {
        this.assignedAt = assignedAt;
    }

    public User getAssignedBy() {
        return assignedBy;
    }

    public void setAssignedBy(User assignedBy) {
        this.assignedBy = assignedBy;
    }

    public EmergencyRole getEmergencyRole() {
        return emergencyRole;
    }

    public void setEmergencyRole(EmergencyRole emergencyRole) {
        this.emergencyRole = emergencyRole;
    }

    public EmergencyStatus getStatus() {
        return status;
    }

    public void setStatus(EmergencyStatus status) {
        this.status = status;
    }

    public LocalDateTime getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(LocalDateTime startedAt) {
        this.startedAt = startedAt;
    }

    public LocalDateTime getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(LocalDateTime completedAt) {
        this.completedAt = completedAt;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    

    




}
