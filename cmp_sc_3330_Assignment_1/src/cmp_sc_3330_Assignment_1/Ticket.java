package cmp_sc_3330_Assignment_1;

public class Ticket {
    private final int id;
    private final Event event;
    private final TicketType ticketType;
    private final String studentName;
    private boolean canceled;
    private boolean admitted;

    public Ticket(int id, Event event, TicketType ticketType, String studentName) {
        if (id <= 0) {
            throw new IllegalArgumentException("Ticket ID must be positive.");
        }
        if (event == null) {
            throw new IllegalArgumentException("Event cannot be null.");
        }
        if (ticketType == null) {
            throw new IllegalArgumentException("TicketType cannot be null.");
        }
        if (studentName == null || studentName.isBlank()) {
            throw new IllegalArgumentException("Student name cannot be null or blank.");
        }

        this.id = id;
        this.event = event;
        this.ticketType = ticketType;
        this.studentName = studentName.trim();
        this.canceled = false;
        this.admitted = false;
    }

    public boolean admit() {
        if (this.canceled || this.admitted) {
            return false;
        }
        this.admitted = true;
        return true;
    }

    public boolean cancel() {
        if (this.admitted || this.canceled) {
            return false;
        }
        this.canceled = true;
        return true;
    }

    public int getId() {
        return id;
    }

    public Event getEvent() {
        return event;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public String getStudentName() {
        return studentName;
    }

    public boolean isCanceled() {
        return canceled;
    }

    public boolean isAdmitted() {
        return admitted;
    }

    public boolean isActive() {
        return !canceled && !admitted;
    }

    public String getStatusString() {
        if (canceled) {
            return "CANCELED";
        }
        if (admitted) {
            return "ADMITTED";
        }
        return "ACTIVE";
    }

    @Override
    public String toString() {
        return String.format("Ticket #%d | Student: %s | Event: %s | Type: %s | Status: %s",
                id, studentName, event.getName(), ticketType.getName(), getStatusString());
    }
}
