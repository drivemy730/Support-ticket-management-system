package com.support.model;
import com.support.helpers.Priority;

public class SoftwareTicket extends Ticket {
    private String operatingSystem;

    public SoftwareTicket(Integer id, String description, Priority priority, String operatingSystem) {
        super(id, description, priority);
        this.operatingSystem = operatingSystem;
    }
    // Getters y Setters...


    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }
}