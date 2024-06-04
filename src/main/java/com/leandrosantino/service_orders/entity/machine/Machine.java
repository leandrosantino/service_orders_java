package com.leandrosantino.service_orders.entity.machine;

import java.util.UUID;

import com.leandrosantino.service_orders.entity.ute.Ute;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "machines")
public class Machine {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(unique = true, nullable = false)
    private String tag;

    @Column(nullable = false)
    private Ute ute;

    // private Technology technology;
    // private List<ServiceOrder> serviceOrders;

}
