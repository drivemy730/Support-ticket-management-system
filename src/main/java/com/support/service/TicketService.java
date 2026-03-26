package com.support.service;

import com.support.exception.TicketNotFoundException;
import com.support.model.Ticket;

import java.util.List;

public interface TicketService
{
    void addTicket(Ticket ticket);

    Ticket getTicketById(Integer id) throws TicketNotFoundException;

    List<Ticket> getHighPriorityTickets();
}
