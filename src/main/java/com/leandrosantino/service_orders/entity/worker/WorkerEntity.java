package com.leandrosantino.service_orders.entity.worker;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.leandrosantino.service_orders.entity.service_order.ServiceOrderEntity;
import com.leandrosantino.service_orders.entity.user.UserEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "worker")
public class WorkerEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(nullable = false)
    private Specialtys specialty;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private UserEntity userData;

    @ManyToMany(mappedBy = "responsibles")
    private Set<ServiceOrderEntity> serviceOrders = new HashSet<>();
}
