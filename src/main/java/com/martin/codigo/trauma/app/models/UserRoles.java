package com.martin.codigo.trauma.app.models;

public enum UserRoles {
    ROLE_ADMIN("ROLE_ADMIN"),
    ROLE_MEDIC("ROLE_MEDIC"),
    ROLE_RECEPTIONIST("ROLE_RECEPTIONIST");

    private final String displayName;

    private UserRoles(String displayName){
        this.displayName = displayName;
    }

    public String getUserRole(){
        return displayName;
    }

}
