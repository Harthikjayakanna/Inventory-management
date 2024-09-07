package com.inventory.administration.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.administration.DTO.Billing;

public interface BillingRepository extends JpaRepository<Billing, Integer> {

}
