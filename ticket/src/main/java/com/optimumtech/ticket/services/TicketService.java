package com.optimumtech.ticket.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.optimumtech.ticket.models.entities.Ticket;
import com.optimumtech.ticket.models.requests.TicketCreate;
import com.optimumtech.ticket.models.requests.TicketUpdate;
import com.optimumtech.ticket.repositories.TicketRepository;

// import jakarta.validation.Valid;

@Service
public class TicketService {
    
    @Autowired
    private TicketRepository ticketRepository;

    public List<Ticket> obtenerTodos() {
        return ticketRepository.findAll();    
    }

    public Ticket obtenerPorId(int id){
        return ticketRepository.findById(id).orElse(null);
    }

    public Ticket registrar(TicketCreate ticket){
        try {
            Ticket nuevoTicket = new Ticket();
            //cammpos de negocio
            nuevoTicket.setFechaRegistro(new Date());
            nuevoTicket.setEstado("CREADO");
            nuevoTicket.setFechaActualizacion(null);
            //campos que vienen del cliente
            nuevoTicket.setTitle(ticket.getTitle());
            nuevoTicket.setDescription(ticket.getDescription());
            nuevoTicket.setEmail(ticket.getEmail());

            return ticketRepository.save(nuevoTicket);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Ticket registrado");
        }
    }

    public Ticket actualizar(TicketUpdate body) {
        Ticket ticket = ticketRepository.findById(body.getId()); //.orElse(null);
        if (ticket == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ticket no encontrado para actualizar");
        }
        if(body.getEstado() != null) {
            ticket.setEstado(body.getEstado());
            ticket.setFechaActualizacion(new Date());
        }
        return ticketRepository.save(ticket);
    }

}
