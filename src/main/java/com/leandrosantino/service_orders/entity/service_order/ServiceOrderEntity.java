package com.leandrosantino.service_orders.entity.service_order;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.leandrosantino.service_orders.entity.cause.CauseEntity;
import com.leandrosantino.service_orders.entity.machine.MachineEntity;
import com.leandrosantino.service_orders.entity.worker.Specialtys;
import com.leandrosantino.service_orders.entity.worker.WorkerEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "service_orders")
public class ServiceOrderEntity {

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
    private ServiceOrderTypes type;

    @Column(nullable = false)
    private Specialtys specialty;

    @ManyToOne()
    @JoinColumn(name = "machine_id")
    private MachineEntity machine;

    @ManyToOne()
    @JoinColumn(name = "cause_id")
    private CauseEntity cause;

    @ManyToMany
    @JoinTable(name = "service_order_responsible", joinColumns = @JoinColumn(name = "service_order_id"), inverseJoinColumns = @JoinColumn(name = "responsible_id"))
    private Set<WorkerEntity> responsibles = new HashSet<>();

    // private List<PreventiveAction> preventiveActions;

}