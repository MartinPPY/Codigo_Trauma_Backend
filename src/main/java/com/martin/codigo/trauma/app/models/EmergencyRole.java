package com.martin.codigo.trauma.app.models;

public enum EmergencyRole {
    PRIMARY("Medico Estandar"),
    ASSISTANT("Medico Asistente"),
    SPECIALIST("Medico Especialista");

    private final String displayName;

    private EmergencyRole(String displayName){
        this.displayName = displayName;
    }

    public String getEmergencyRole(){
        return this.displayName;
    }

}
