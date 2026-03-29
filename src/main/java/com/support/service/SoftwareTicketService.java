package com.support.service;

import com.support.exception.TicketNotFoundException;
import com.support.helpers.Priority;
import com.support.model.SoftwareTicket;
import com.support.model.Ticket;

import java.util.List;

public interface SoftwareTicketService
{
    SoftwareTicket createSoftwareBugTicket(String desc, String os, Priority priority);

    SoftwareTicket getSoftwareTicketById(Integer id) throws TicketNotFoundException;

    List<SoftwareTicket> getHighPrioritySoftwareTickets();
}
