package com.martin.codigo.trauma.app.models;


public enum EmergencyStatus {
    PENDING("Pendiente"),
    IN_PROGRESS("En progreso"),
    RESOLVED("Resuelto"),
    CANCELLED("Cancelado");

    private final String displayName;

    private EmergencyStatus(String dispayName){
        this.displayName = dispayName;
    }

    public String getDisplayName(){
        return this.displayName;
    }

    
}
