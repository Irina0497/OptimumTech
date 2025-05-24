package com.optimumtech.api_payment.models.requests;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import lombok.Data;

@Data
public class PaymentCreate {

    @NotBlank
    private String userId;

    @NotBlank
    private String courseId;

    @Positive
    private int amount;

    @NotBlank
    private String paymentMethod;
    
    private String email;

}
