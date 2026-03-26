package com.support.model;

import com.support.helpers.Priority;

public abstract class Ticket {
    private Integer id;
    private String description;
    private Priority priority;

    public Ticket(Integer id, String description, Priority priority) {
        this.id = id;
        this.description = description;
        this.priority = priority;
    }

    // Getters y Setters...


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }
}