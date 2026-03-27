package com.support.service;

import com.support.exception.TicketNotFoundException;
import com.support.model.SoftwareTicket;
import com.support.model.Ticket;

import java.util.List;

public interface SoftwareTicketService
{
    SoftwareTicket createSoftwareBugTicket(SoftwareTicket ticket);

    SoftwareTicket getSoftwareTicketById(Integer id) throws TicketNotFoundException;

    List<SoftwareTicket> getHighPrioritySoftwareTickets();
}
