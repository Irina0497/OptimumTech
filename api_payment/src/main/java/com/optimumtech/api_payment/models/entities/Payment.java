package com.optimumtech.api_payment.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
@Entity
@Table(name = "pago")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="usuario_id", nullable = false)
    private String userId;

    @Column(name="curso_id", nullable = false)
    private String courseId;

    @Column(name="monto", nullable = false)
    private int amount; 

    @Column(name="estado")
    private String status; // Pendiente, Completado, Fallido

    @Column(name="metodo_pago", nullable = false)
    private String paymentMethod; // Tarjeta de crédito, PayPal, etc.
    
    @Column(name="fecha_pago")
    private Date fechaPago;

}
