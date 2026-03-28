

package com.support.commandLineInterface;
import com.support.exception.TicketNotFoundException;
import com.support.model.HardwareTicket;
import com.support.model.SoftwareTicket;
import com.support.model.Ticket;
import com.support.service.HardwareTicketCreator;
import com.support.service.HardwareTicketService;
import com.support.service.SoftwareTicketCreator;

import java.util.List;
import java.util.Scanner;


public class Presentation
{

    static Scanner scanner = new Scanner(System.in);



    public static void main(String[] args)
    {
        boolean exit = false;


        HardwareTicket hardwareTicket = new HardwareTicket();
        HardwareTicketCreator hardwareTicketCreator = new HardwareTicketCreator();

        SoftwareTicket softwareTicket = new SoftwareTicket();
        SoftwareTicketCreator softwareTicketCreator = new SoftwareTicketCreator();

        while (!exit)
        {
            int mainMenuResponse = showMainMenu();


            switch (mainMenuResponse)
            {
                case 1: //create a hardware ticket


                    System.out.println("Input bug details: ");
                    hardwareTicket.setDescription(scanner.nextLine());

                    System.out.println("Input serial number: ");
                    hardwareTicket.setSerialNumber(scanner.nextLine());

                    hardwareTicketCreator.createHardwareBugTicket(hardwareTicket);
                    System.out.println("Hardware Ticket created with ID: " + hardwareTicket.getId());
                    break;


                case 2: // //create a software ticket

                    System.out.print("Input bug details: ");
                    softwareTicket.setDescription(scanner.nextLine());

                    System.out.print("Input serial number: ");
                    softwareTicket.setOperatingSystem(scanner.nextLine());

                    softwareTicketCreator.createSoftwareBugTicket(softwareTicket);

                    System.out.println("Hardware Ticket created with ID: " + softwareTicket.getId() );
                    break;

                case 3:
                    //later
                    break;

                case 4:

                    System.out.print("Input hardware ticketID : ");
                    int ticketIdToSearch = scanner.nextInt();

                    HardwareTicket hardwareTicketfound = hardwareTicketCreator.getHardwareTicketById(ticketIdToSearch);
                    System.out.println(hardwareTicketfound.getId());
                    System.out.println(hardwareTicketfound.getDescription());
                    System.out.println(hardwareTicketfound.getSerialNumber());

                    break;

                case 5:

                    System.out.print("Input Software ticketID : ");
                    SoftwareTicketCreator softwareTicketCreator1 = new SoftwareTicketCreator();
                    softwareTicketCreator1.getSoftwareTicketById(scanner.nextInt());

                    System.out.println(softwareTicketCreator1.getSoftwareTicketById ( (scanner.nextInt()) ) );


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



}
