package cmp_sc_3330_Assignment_1;

public class TicketBook {
    private Ticket[] tickets;
    private int count;

    public TicketBook(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than zero.");
        }
        tickets = new Ticket[capacity];
        count = 0;
    }

    public Ticket createTicket(int id, Event event, TicketType type, String studentName) {
        if (count >= tickets.length) {
            throw new IllegalStateException("Array is full");
        }
        
        Ticket t = new Ticket(id, event, type, studentName);
        tickets[count] = t;
        count++;
        return t;
    }

    public Ticket findById(int id) {
        for (int i = 0; i < count; i++) {
            if (tickets[i].getId() == id) {
                return tickets[i];
            }
        }
        return null;
    }

    public void printAll() {
        for (int i = 0; i < count; i++) {
            System.out.println(tickets[i]);
        }
    }

    public void printForEvent(Event event) {
        for (int i = 0; i < count; i++) {
            // Using == because we can't override equals()
            if (tickets[i].getEvent() == event) {
                System.out.println(tickets[i]);
            }
        }
    }
}