package com.support.service;

import com.support.model.SoftwareTicket;
import com.support.model.Ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketServiceImpl
{


    Map<Integer, Ticket> ticketStorage = new HashMap<>();


    public void addTicket( Ticket ticket)
    {

            Integer lastTicketCounter = 0;

        System.out.println("");
            ticket.setId(ticket.getId());
            ticket.setDescription(ticket.getDescription());
            ticket.setPriority(ticket.getPriority());


            ticketStorage.put(ticket.getId(),ticket);

    }
}
