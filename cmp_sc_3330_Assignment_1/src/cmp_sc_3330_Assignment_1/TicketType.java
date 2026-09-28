package cmp_sc_3330_Assignment_1;

public class TicketType {
    private final String name;
    private final double price;

    public TicketType(String name, double price) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Ticket type name cannot be null or blank.");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Ticket price cannot be negative.");
        }
        this.name = name.trim();
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("%s ($%.2f)", name, price);
    }
}
