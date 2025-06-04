package com.optimumtech.ticket.models.requests;


import jakarta.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class TicketCreate {

    @NotBlank
    private String email;

    @NotBlank
    private String title;

    @NotBlank
    private String description;
}

