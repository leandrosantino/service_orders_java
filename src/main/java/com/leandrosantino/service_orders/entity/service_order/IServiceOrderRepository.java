package com.leandrosantino.service_orders.entity.service_order;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IServiceOrderRepository extends JpaRepository<ServiceOrder, UUID> {

}
