

package com.support.commandLineInterface;
import com.support.exception.TicketNotFoundException;
import com.support.helpers.Priority;
import com.support.model.HardwareTicket;
import com.support.model.SoftwareTicket;
import com.support.service.HardwareTicketCreator;
import com.support.service.SoftwareTicketCreator;

import java.util.ArrayList;
import java.util.Scanner;


public class Presentation
{

    static Scanner scanner = new Scanner(System.in);



    public static void main(String[] args)
    {
        boolean exit = false;


        HardwareTicketCreator hardwareTicketCreator = new HardwareTicketCreator();

        SoftwareTicketCreator softwareTicketCreator = new SoftwareTicketCreator();



        while (!exit)
        {
            int mainMenuResponse = showMainMenu();

            switch (mainMenuResponse) {
                case 1: //create a hardware ticket
                    HardwareTicket hardwareTicket = new HardwareTicket();


                    System.out.println("Input bug details: ");
                    hardwareTicket.setDescription(scanner.nextLine());

                    System.out.println("Input serial number: ");
                    hardwareTicket.setSerialNumber(scanner.nextLine());

                    System.out.println("Whats the priority: ?");
                    int priorityHardwareChosenMenu;
                    priorityHardwareChosenMenu = showPriorityMenu();
                    Priority hardwareTicketResponse;
                    hardwareTicketResponse = priorityResponse(priorityHardwareChosenMenu);
                    hardwareTicket.setPriority(hardwareTicketResponse);



                    hardwareTicketCreator.createHardwareBugTicket(hardwareTicket);
                    System.out.println("Hardware Ticket created with ID: " + hardwareTicket.getId());
                    break;


                case 2: // //create a software ticket

                    System.out.print("Input bug details: ");
                    String desc = scanner.nextLine();

                    System.out.print("Input OS: ");
                    String os = scanner.nextLine();

                    System.out.println("Whats the priority: ?");
                    int priorityChoice = showPriorityMenu();
                    Priority priority = priorityResponse(priorityChoice);

                    SoftwareTicket createdTicket =
                            softwareTicketCreator.createSoftwareBugTicket(desc, os, priority);

                    System.out.println("Software Ticket created with ID: " + createdTicket.getId());

                    break;

                case 3:

                    ArrayList<Object> highPriorityTickets = new ArrayList<>();

                    highPriorityTickets.add(hardwareTicketCreator.getHighPriorityHardwareTickets());
                    highPriorityTickets.add(softwareTicketCreator.getHighPrioritySoftwareTickets());

                    System.out.print(highPriorityTickets);
                    break;

                case 4: //SEARCH AND PRINT HARDWARE TICKETS

                    System.out.print("Input hardware ticketID : ");
                    int ticketIdToSearch = scanner.nextInt();
                    scanner.nextLine();

                    try
                    {
                        HardwareTicket hardwareTicketfound = hardwareTicketCreator.getHardwareTicketById(ticketIdToSearch);
                        System.out.println(hardwareTicketfound.getId());
                        System.out.println(hardwareTicketfound.getDescription());
                        System.out.println(hardwareTicketfound.getSerialNumber());
                        System.out.println(hardwareTicketfound.getPriority());


                    }
                    catch (TicketNotFoundException e)
                    {
                        System.out.println(e.getMessage());
                    }


                    break;

                case 5: //SEARCH AND PRINT SOFTWARE TICKETS

                    System.out.print("Input Software ticketID : ");
                    int idFound = scanner.nextInt();
                    scanner.nextLine();

                    try
                    {
                        SoftwareTicket sotwareTicketFound= softwareTicketCreator.getSoftwareTicketById(idFound);
                        System.out.println(sotwareTicketFound.getId());
                        System.out.println(sotwareTicketFound.getDescription());
                        System.out.println(sotwareTicketFound.getOperatingSystem());
                        System.out.println(sotwareTicketFound.getPriority());

                    }
                    catch (TicketNotFoundException e)
                    {
                        System.out.println(e.getMessage());

                    }

                    break;


                case 0:

                    exit = true;

                break;


            }


        }



    }

    public static int showMainMenu()
    {

        System.out.println("=== Support Ticket CLI ===");
        System.out.println("1. Create Hardware Ticket");
        System.out.println("2. Create Software Ticket");
        System.out.println("3. Show high priority Tickets");
        System.out.println("4. Search Hardware Tickets");
        System.out.println("5. Search Software Tickets");
        System.out.println("0. Exit");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;

    }


    public static int showPriorityMenu()
    {
        System.out.println("1. LOW");
        System.out.println("2. MEDIUM");
        System.out.println("3. HIGH");
        System.out.print("Enter the # of your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    public static Priority priorityResponse(int userInput)
    {

        if (userInput == 1)
        {
            return Priority.LOW;
        }
        else if (userInput == 2 )
        {
            return Priority.MEDIUM;
        }

        return Priority.HIGH;

    }



}
