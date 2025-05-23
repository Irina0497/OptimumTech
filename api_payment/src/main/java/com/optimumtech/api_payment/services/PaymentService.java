package com.optimumtech.api_payment.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.optimumtech.api_payment.models.entities.Payment;
import com.optimumtech.api_payment.models.requests.PaymentCreate;
import com.optimumtech.api_payment.models.requests.PaymentUpdate;
import com.optimumtech.api_payment.repositories.PaymentRepository;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;


    public List<Payment> obtenerTodos() {
        return paymentRepository.findAll();
    }

    public Payment obtenerPorId(int id) {
        return paymentRepository.findById(id).orElseThrow(() -> new RuntimeException("Pago no encontrado"));
    }

    public Payment registrar(PaymentCreate dto) {
        Payment payment = new Payment();
        payment.setUserId(dto.getUserId());
        payment.setCourseId(dto.getCourseId());
        payment.setAmount(dto.getAmount());
        payment.setStatus("Pendiente");
        payment.setFechaPago(new Date());
        payment.setPaymentMethod(dto.getPaymentMethod());
        return paymentRepository.save(payment);
    }

    public Payment actualizar(PaymentUpdate dto) {
        Payment payment = obtenerPorId(dto.getId());
        if(dto.getStatus() != null) {
            payment.setStatus(dto.getStatus());
        }
        return paymentRepository.save(payment);
    }

    public void eliminar(int id) {
        Payment pago = paymentRepository.findById(id).orElse(null);
        if (pago == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pago no encontrado");
        }
        paymentRepository.delete(pago);
    }
}