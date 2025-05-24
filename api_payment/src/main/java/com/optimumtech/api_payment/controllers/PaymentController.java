package com.optimumtech.api_payment.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.optimumtech.api_payment.models.entities.Payment;
import com.optimumtech.api_payment.models.requests.PaymentCreate;
import com.optimumtech.api_payment.models.requests.PaymentResponse;
import com.optimumtech.api_payment.models.requests.PaymentUpdate;


import com.optimumtech.api_payment.services.PaymentService;
// C:\Users\irina\Documents\Optimum Tech\api_payment\src\main\java\com\optimumtech\api_payment\services

import jakarta.validation.Valid;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/")
    public List<Payment> obtenerTodos() {
        return paymentService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Payment obtenerUno(@PathVariable int id) {
        return paymentService.obtenerPorId(id);
    }

    @PostMapping("/")
    public PaymentResponse registrar(@Valid @RequestBody PaymentCreate body) {
        return paymentService.registrar(body);
    }

    @PutMapping()
    public Payment actualizar(@Valid @RequestBody PaymentUpdate body) {
        return paymentService.actualizar(body);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable int id) {
        paymentService.eliminar(id);
        return "ok";
    }

}