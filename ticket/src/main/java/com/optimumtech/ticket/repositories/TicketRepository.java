package com.optimumtech.ticket.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.optimumtech.ticket.models.entities.Ticket;
import java.util.Optional;



@Repository
public interface TicketRepository extends JpaRepository<Ticket, String> {

    Ticket findByEmail(String email);

    Optional<Ticket> findById(String id);
}
