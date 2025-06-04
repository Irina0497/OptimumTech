package com.optimumtech.ticket.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.optimumtech.ticket.models.entities.Ticket;



@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    
    Ticket findByEmail(String email);

    Ticket findById(String id);
}
