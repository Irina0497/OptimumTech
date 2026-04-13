package com.optimumtech.ticket.models.requests;

import jakarta.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class TicketUpdate {
    
    @NotBlank
    private String id;

    @NotBlank
    private String estado;    
}
