package bank;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Represents a single transaction within the bank account.
 */
public class Transaction {
    /**
     * The date the transaction was made.
     */
    private Date date;
    /**
     * The amount transacted.
     */
    private double amount;
    /**
     * The balance after the transaction.
     */
    private double balance;

    /**
     * Constructor for the {@code bank.Transaction} class.
     * Initializes the date and amount transacted.
     *
     * @param date The date the transaction was made
     * @param amount The amount transacted
     */
    public Transaction(Date date, double amount, double balance) {
        this.date = date;
        this.amount = amount;
        this.balance = balance;
    }

    /**
     * {@inheritDoc}
     */
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("d MMM yyyy hh:mm:ssa");
        String formattedDate = dateFormat.format(date);

        if (amount >= 0) {
            return String.format("%s | %.2f  | %.2f", formattedDate, amount, balance);
        } else {
            return String.format("%s | %.2f | %.2f", formattedDate, amount, balance);
        }
    }
}
