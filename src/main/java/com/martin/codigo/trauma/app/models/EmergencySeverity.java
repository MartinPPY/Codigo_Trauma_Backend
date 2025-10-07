package com.martin.codigo.trauma.app.models;

public enum EmergencySeverity {
    CRITICAL("Critico"),
    HIGH("Alto"),
    MEDIUM("Mediano"),
    LOW("Bajo");

    private final String displayName;

    private EmergencySeverity(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return this.displayName;
    }

}
