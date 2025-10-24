package com.martin.codigo.trauma.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.martin.codigo.trauma.app.entities.UsersEmergencies;
import com.martin.codigo.trauma.app.models.UsersEmergenciesDto;

public interface UsersEmergencyRepository extends CrudRepository<UsersEmergencies, Long> {

    @Query("""
            SELECT  new com.martin.codigo.trauma.app.models.UsersEmergenciesDto(
                ue.id,
                ue.assignedAt, 
                CONCAT(ua.name, ' ' ,ua.lastname),
                ue.completedAt,
                e.description,
                CONCAT(u.name, ' ' ,u.lastname),
                ue.notes,
                ue.emergencyRole,
                ue.status
                ) 
            FROM UsersEmergencies ue
                JOIN  ue.user u
                JOIN  ue.assignedBy ua
                JOIN  ue.emergency e
            """)
    List<UsersEmergenciesDto> findAllDto();

}
