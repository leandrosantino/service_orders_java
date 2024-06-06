package com.leandrosantino.service_orders.entity.service_order;

public enum ServiceOrderTypes {
    PREVENTIVE("preventive"),
    CORRECTIVE("corrective"),
    PROGRAMMED("programmed"),
    SETUP("setup"),
    TOOLING("toolin");

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String type) {
        this.name = type;
    }

    ServiceOrderTypes(String name) {
        this.name = name;
    }

}
