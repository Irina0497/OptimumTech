package com.optimumtech.api_payment.models.requests;

import lombok.Data;
import java.util.Date;

@Data
public class PaymentResponse {
    private int id;
    private String userId;
    private String courseId;
    private double amount;
    private String status;
    private String paymentMethod;
    private Date fechaPago;
    private String email;
    private String name;
}
