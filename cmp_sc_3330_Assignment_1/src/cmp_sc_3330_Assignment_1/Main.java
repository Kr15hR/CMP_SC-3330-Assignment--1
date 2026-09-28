package cmp_sc_3330_Assignment_1;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Campus Event Ticket Management System Demo ===\n");

        // Initialize TicketManager with capacity for 10 tickets
        TicketManager manager = new TicketManager(10);

        // 1. Create at least 2 events
        Event guestLecture = new Event("Cybersecurity Guest Lecture", "Engineering Building");
        Event workshop = new Event("Python Data Analytics Workshop", "Student Center Room 201");

        // 2. Create at least 2 ticket types
        TicketType studentType = new TicketType("Student Pass", 0.00);
        TicketType generalType = new TicketType("General Admission", 15.50);

        // 3. Issue at least 5 tickets across events and ticket types
        System.out.println("--- 1. Issuing Tickets ---");
        int ticket1Id = manager.createTicket(guestLecture, studentType, "Krish Rajpurohit");
        int ticket2Id = manager.createTicket(guestLecture, generalType, "Alex Smith");
        int ticket3Id = manager.createTicket(guestLecture, studentType, "Jordan Lee");
        int ticket4Id = manager.createTicket(workshop, studentType, "Taylor Swift");
        int ticket5Id = manager.createTicket(workshop, generalType, "Morgan Freeman");

        System.out.println("Successfully issued 5 tickets (IDs: " 
                + ticket1Id + ", " + ticket2Id + ", " + ticket3Id + ", " 
                + ticket4Id + ", " + ticket5Id + ").\n");

        // 4. Print all tickets
        System.out.println("--- 2. All Issued Tickets ---");
        manager.printAllTickets();
        System.out.println();

        // 5. Admit multiple tickets (uses ticket1Id, ticket3Id, ticket4Id)
        System.out.println("--- 3. Admitting Tickets ---");
        boolean admitted1 = manager.admitTicket(ticket1Id);
        boolean admitted3 = manager.admitTicket(ticket3Id);
        boolean admitted4 = manager.admitTicket(ticket4Id);

        System.out.println("Admit Ticket #" + ticket1Id + " (Krish Rajpurohit): " + (admitted1 ? "SUCCESS" : "FAILED"));
        System.out.println("Admit Ticket #" + ticket3Id + " (Jordan Lee): " + (admitted3 ? "SUCCESS" : "FAILED"));
        System.out.println("Admit Ticket #" + ticket4Id + " (Taylor Swift): " + (admitted4 ? "SUCCESS" : "FAILED"));
        System.out.println();

        // 6. Cancel multiple tickets (uses ticket2Id, ticket5Id)
        System.out.println("--- 4. Canceling Tickets ---");
        boolean canceled2 = manager.cancelTicket(ticket2Id);
        boolean canceled5 = manager.cancelTicket(ticket5Id);

        System.out.println("Cancel Ticket #" + ticket2Id + " (Alex Smith): " + (canceled2 ? "SUCCESS" : "FAILED"));
        System.out.println("Cancel Ticket #" + ticket5Id + " (Morgan Freeman): " + (canceled5 ? "SUCCESS" : "FAILED"));
        System.out.println();

        // 7. Demonstrate invalid operations
        System.out.println("--- 5. Demonstrating Invalid Operations ---");
        System.out.println("Attempting to admit canceled Ticket #" + ticket2Id + "...");
        boolean invalidAdmit = manager.admitTicket(ticket2Id);
        System.out.println("Result of admitting canceled ticket: " + (invalidAdmit ? "SUCCESS" : "REJECTED (Invalid State)"));

        System.out.println("Attempting to admit already admitted Ticket #" + ticket1Id + "...");
        boolean doubleAdmit = manager.admitTicket(ticket1Id);
        System.out.println("Result of admitting ticket twice: " + (doubleAdmit ? "SUCCESS" : "REJECTED (Already Admitted)"));
        System.out.println();

        // 8. Print all tickets to show final states
        System.out.println("--- 6. All Tickets (Post-Operations) ---");
        manager.printAllTickets();
        System.out.println();

        // 9. Print tickets for a single specific event
        System.out.println("--- 7. Tickets for 'Cybersecurity Guest Lecture' Only ---");
        manager.printTicketsForEvent(guestLecture);
    }
}