package com.support.service;

import com.support.exception.TicketNotFoundException;
import com.support.helpers.Priority;
import com.support.model.HardwareTicket;
import com.support.model.SoftwareTicket;
import com.support.model.Ticket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HardwareTicketCreator implements HardwareTicketService
{



    // "Hardware TICKET DATA BASE"
    private Map<Integer, HardwareTicket> hardwareTicketStorage = new HashMap<>();
    private int currentId = 0;


    @Override
    public HardwareTicket createHardwareBugTicket(HardwareTicket ticket)
    {
        currentId++;
        ticket.setId(currentId);
        hardwareTicketStorage.put(currentId, ticket);
        return ticket;

    }


    @Override
    public HardwareTicket getHardwareTicketById(Integer id) throws TicketNotFoundException {
        HardwareTicket ticket = hardwareTicketStorage.get(id);

        if (ticket == null)
        {
            throw new TicketNotFoundException("Ticket not found for ID " + id);
        }

        return ticket;
    }


    @Override
    public List<HardwareTicket> getHighPriorityHardwareTickets()
    {

        List<HardwareTicket> priorityHardwareTickets = new ArrayList<> ();

        for (HardwareTicket ticket : hardwareTicketStorage.values())
        {
            if(Priority.HIGH.equals(ticket.getPriority()))
            {
                priorityHardwareTickets.add(ticket);
            }
        }
        return priorityHardwareTickets;
    }



    //constructors
    public HardwareTicketCreator(Map<Integer, HardwareTicket> hardwareTicketStorage)
    {
        this.hardwareTicketStorage = hardwareTicketStorage;
    }

    public HardwareTicketCreator()
    {

    }
}
