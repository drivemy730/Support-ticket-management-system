package com.support.model;
import com.support.helpers.Priority;

public class HardwareTicket extends Ticket {
    private String serialNumber;

    public HardwareTicket(Integer id, String description, Priority priority, String serialNumber)
    {
        super(id, description, priority);
        this.serialNumber = serialNumber;
    }

    public HardwareTicket() {
    }

    // Getters y Setters...


    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
}