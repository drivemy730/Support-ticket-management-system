package com.support.service;

import com.support.exception.TicketNotFoundException;
import com.support.helpers.Priority;
import com.support.model.SoftwareTicket;
import com.support.model.Ticket;

import java.util.*;

public class SoftwareTicketCreator implements SoftwareTicketService
{

    // "SOFTWARE TICKET DATA BASE"
    private Map<Integer, SoftwareTicket> softwareTicketStorage = new HashMap<>();
    private int currentId;


    @Override
    public SoftwareTicket createSoftwareBugTicket(String desc, String os, Priority priority)
    {
        SoftwareTicket ticket = new SoftwareTicket();
        currentId++;
        ticket.setId(currentId);
        ticket.setDescription(desc);
        ticket.setOperatingSystem(os);
        ticket.setPriority(priority);

        softwareTicketStorage.put(currentId, ticket);
        return ticket;
    }



    @Override
    public SoftwareTicket getSoftwareTicketById(Integer id) throws TicketNotFoundException
    {
        SoftwareTicket ticket = softwareTicketStorage.get(id);
        if (ticket == null)
        {
            throw new TicketNotFoundException("sofware ticket not found with id: " + id);
        }

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

    //constructors

    public SoftwareTicketCreator(Map<Integer, SoftwareTicket> softwareTicketStorage) {
        this.softwareTicketStorage = softwareTicketStorage;
    }

    public SoftwareTicketCreator() {
    }


}
