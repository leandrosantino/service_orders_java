package com.leandrosantino.service_orders.entity.service_order;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

import com.leandrosantino.service_orders.entity.machine.Machine;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "service_orders")
public class ServiceOrder {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private String weekCode;

    @Column(nullable = false)
    private LocalDateTime date;

    @Column(nullable = false, length = 300)
    private String problemDescription;

    @Column(nullable = false, length = 300)
    private String solutionDescription;

    private Date createdAt;
    private Date updatedAt;

    @Column(nullable = false)
    private int durationInMinutes;

    @Column(nullable = false)
    private boolean concluded;

    @Column(nullable = false)
    private String type;

    private String specialty;

    private Machine machine;

    // private Cause cause;
    // private List<Worker> responsibles;
    // private List<PreventiveAction> preventiveActions;

}