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

import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/")
    @Operation(
        summary = "Obtiene todos los pagos",
        description = "Recupera una lista completa de todos los pagos registrados en el sistema."
    )
    public List<Payment> obtenerTodos() {
        return paymentService.obtenerTodos();
    }

    @GetMapping("/{id}")
    @Operation(
        summary = "Obtiene un pago por ID",
        description = "Recupera los detalles de un pago específico utilizando su ID."
    )
    public Payment obtenerUno(@PathVariable int id) {
        return paymentService.obtenerPorId(id);
    }

    @PostMapping("/")
    @Operation(
        summary = "Registra un nuevo pago",
        description = "Permite registrar un nuevo pago con la información proporcionada."
    )
    public PaymentResponse registrar(@Valid @RequestBody PaymentCreate body) {
        return paymentService.registrar(body);
    }

    @PutMapping()
    @Operation(
        summary = "Actualiza un pago existente",
        description = "Permite actualizar la información de un pago existente con los nuevos datos proporcionados."
    )
    public PaymentResponse actualizar(@Valid @RequestBody PaymentUpdate body) {
        return paymentService.actualizar(body);
    }

    @DeleteMapping("/{id}")
    @Operation(
        summary = "Elimina un pago por ID",
        description = "Elimina un pago del sistema utilizando su ID."
    )
    public String eliminar(@PathVariable int id) {
        paymentService.eliminar(id);
        return "ok";
    }
}
