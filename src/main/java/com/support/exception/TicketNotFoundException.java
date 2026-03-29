package com.support.exception;

public class TicketNotFoundException extends Throwable
{


    public TicketNotFoundException(String message)
    {
        super(message);
    }

    public TicketNotFoundException()
    {
        super();
    }


}
