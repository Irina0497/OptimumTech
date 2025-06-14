package com.optimumtech.ticket.controllers;

import java.util.List;

import com.optimumtech.ticket.models.requests.TicketCreate;
import com.optimumtech.ticket.models.requests.TicketUpdate;
import com.optimumtech.ticket.services.TicketService;
import com.optimumtech.ticket.models.entities.Ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/ticket")
public class TicketController {
    
    @Autowired
    private TicketService ticketService;

    @GetMapping("/")
    public List<Ticket> obtenerTodos() {
        return ticketService.obtenerTodos();
    }

    // @GetMapping("/{id}")
    // public User obtenerUno(@PathVariable int id) {
    //     return userService.obtenerPorId(id);
    // }

    @PostMapping("/")
    public Ticket registrar(@Valid @RequestBody TicketCreate body) {
        return ticketService.registrar(body);
    }

    @PutMapping()
    public Ticket actualizar(@Valid @RequestBody TicketUpdate body) {
        return ticketService.actualizar(body);
    }
    
}
