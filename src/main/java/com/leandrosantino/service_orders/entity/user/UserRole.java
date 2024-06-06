package com.leandrosantino.service_orders.entity.user;

public enum UserRole {
    ADMIN("admin"),
    WORKER("worker"),
    LEADER("leader"),
    ROOT("root");

    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    UserRole(String role) {
        this.role = role;
    }

}
