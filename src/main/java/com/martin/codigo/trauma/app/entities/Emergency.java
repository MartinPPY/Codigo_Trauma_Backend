package com.martin.codigo.trauma.app.entities;

import java.time.LocalDateTime;

import com.martin.codigo.trauma.app.models.EmergencySeverity;
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
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "emergencies")
public class Emergency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    private EmergencySeverity severity;

    @Enumerated(EnumType.STRING)
    private EmergencyStatus status;

    @NotNull
    @Column(name = "date_at")
    private LocalDateTime createAt;

    @NotNull
    @Column(name = "date_update")
    private LocalDateTime updateAt;

    @Column(name = "resolved_at")
    private LocalDateTime resolvedAt;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;

    public Emergency() {
        this.status = EmergencyStatus.valueOf("PENDING");
        createAt = LocalDateTime.now();
        updateAt = LocalDateTime.now();
    }

    public Emergency(String description, EmergencySeverity severity ,User createdBy) {

        this.description = description;
        this.severity = severity;
        this.createdBy = createdBy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EmergencySeverity getSeverity() {
        return severity;
    }

    public void setSeverity(EmergencySeverity severity) {
        this.severity = severity;
    }

    public EmergencyStatus getStatus() {
        return status;
    }

    public void setStatus(EmergencyStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    public LocalDateTime getResolvedAt() {
        return resolvedAt;
    }

    public void setResolvedAt(LocalDateTime resolvedAt) {
        this.resolvedAt = resolvedAt;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    

}
