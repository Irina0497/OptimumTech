package com.optimumtech.api_payment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.optimumtech.api_payment.models.entities.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}