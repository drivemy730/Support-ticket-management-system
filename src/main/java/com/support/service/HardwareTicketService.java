package com.support.service;

import com.support.exception.TicketNotFoundException;
import com.support.model.HardwareTicket;
import com.support.model.SoftwareTicket;

import java.util.List;

public interface HardwareTicketService
{

    HardwareTicket createHardwareBugTicket(HardwareTicket ticket);

    HardwareTicket getHardwareTicketById(Integer id) throws TicketNotFoundException;

    List<HardwareTicket> getHighPriorityHardwareTickets();


}
