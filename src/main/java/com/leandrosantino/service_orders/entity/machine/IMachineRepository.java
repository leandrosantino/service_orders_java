package com.leandrosantino.service_orders.entity.machine;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IMachineRepository extends JpaRepository<Machine, UUID> {

}
