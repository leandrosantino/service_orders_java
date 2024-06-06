package com.leandrosantino.service_orders.entity.worker;

public enum Specialtys {
    MECHANICS("mechanics"),
    ELECTRICAL("electrical"),
    TOOLING("toolin");

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    Specialtys(String name) {
        this.name = name;
    }

}
