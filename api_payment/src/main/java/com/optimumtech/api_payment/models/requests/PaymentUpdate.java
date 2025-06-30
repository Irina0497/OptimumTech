package com.optimumtech.api_payment.models.requests;


import lombok.Data;

@Data
public class PaymentUpdate {
    private int id;
    private String status; // para actualizar el estado, "Completado"
}
