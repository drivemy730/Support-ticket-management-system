package com.support.service;

import com.support.exception.TicketNotFoundException;
import com.support.helpers.Priority;
import com.support.model.SoftwareTicket;
import com.support.model.Ticket;

import java.util.*;

public class SoftwareTicketCreator implements SoftwareTicketService
{
    public SoftwareTicketCreator(Map<Integer, SoftwareTicket> softwareTicketStorage) {
        this.softwareTicketStorage = softwareTicketStorage;
    }

    public SoftwareTicketCreator() {
    }

    // "SOFTWARE TICKET DATA BASE"
    Map<Integer, SoftwareTicket> softwareTicketStorage = new HashMap<>();


    @Override
    public SoftwareTicket createSoftwareBugTicket(SoftwareTicket ticket)
    {
        int nextId = softwareTicketStorage.size() + 1;
        ticket.setId(nextId);

        softwareTicketStorage.put(nextId, ticket);

        return ticket;
    }

    @Override
    public SoftwareTicket getSoftwareTicketById(Integer id)
    {
        return softwareTicketStorage.get(id);

    };

    @Override
    public List<SoftwareTicket> getHighPrioritySoftwareTickets()
    {
        List<SoftwareTicket> highPriorityTickets = new ArrayList<>();

        for (SoftwareTicket ticket : softwareTicketStorage.values())
        {
            if (Priority.HIGH.equals(ticket.getPriority()))
            {
                highPriorityTickets.add(ticket);
            }
        }

        return highPriorityTickets;
    }


}
