package cmp_sc_3330_Assignment_1;

// Manages all ticket operations and tracks ticket numbers.
public class TicketManager {
    private final TicketBook ticketBook;
    private int nextTicketId;

    // Sets up the manager with a max capacity and starts ticket IDs at 1.
    public TicketManager(int capacity) {
        this.ticketBook = new TicketBook(capacity);
        this.nextTicketId = 1;
    }

    public int createTicket(Event event, TicketType type, String studentName) {
        int id = nextTicketId++; // Or your counter logic
        ticketBook.createTicket(id, event, type, studentName);
        return id;
    }

    // Finds a ticket by ID and marks it as used/admitted.
    public boolean admitTicket(int ticketId) {
        Ticket ticket = ticketBook.findById(ticketId);
        if (ticket == null) {
            return false;
        }
        return ticket.admit();
    }

    // Finds a ticket by ID and cancels it.
    public boolean cancelTicket(int ticketId) {
        Ticket ticket = ticketBook.findById(ticketId);
        if (ticket == null) {
            return false;
        }
        return ticket.cancel();
    }

    // Prints every ticket stored in the book.
    public void printAllTickets() {
        ticketBook.printAll();
    }

    // Prints only the tickets for a specific event.
    public void printTicketsForEvent(Event event) {
        ticketBook.printForEvent(event);
    }
}