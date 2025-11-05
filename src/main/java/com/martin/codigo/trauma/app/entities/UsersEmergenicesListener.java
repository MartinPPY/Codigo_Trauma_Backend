package com.martin.codigo.trauma.app.entities;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.martin.codigo.trauma.app.models.EmergencyStatus;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PostUpdate;

@Component
public class UsersEmergenicesListener {

    @PersistenceContext
    private EntityManager entityManager;

    @PostUpdate
    public void onAfterUpdateEmergency(UsersEmergencies ue) {

        Emergency emergency = ue.getEmergency();
        User user = ue.getUser();

        if (emergency == null)
            return;

        emergency.setStatus(ue.getStatus());

        /* SI LA EMERGENCIA FUE CANCELADA O RESUELTA SE ACTUALIZARA LA FECHA RESUELTA */
        if (ue.getStatus() == EmergencyStatus.RESOLVED || ue.getStatus() == EmergencyStatus.CANCELLED) {
            emergency.setResolvedAt(LocalDateTime.now());
            ue.setCompletedAt(LocalDateTime.now());
            user.setActive(true);

        }

        emergency.setUpdateAt(LocalDateTime.now());
    }

}
