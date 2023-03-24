package bank.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * Represents a bank account.
 */
public class BankAccount {
    /**
     * The current balance of the bank account.
     */
    private double balance;
    /**
     * The list that contains the transaction history.
     */
    private ArrayList<Transaction> transactions;

    /**
     * Constructor for the {@code BankAccount} class.
     * Initializes the balance and transactions of the bank account.
     *
     */
    public BankAccount() {
        this.balance = 0;
        this.transactions = new ArrayList<>();
    }

    /**
     * Getter method for balance.
     *
     * @return balance The balance
     */
    public double getBalance() {
        return this.balance;
    }

    /**
     * Handles a transaction and updates the balance and transaction history.
     *
     * @param amount The amount transacted
     */
    public void transact(double amount) {
        Date date = new Date();
        balance += amount;
        Transaction transaction = new Transaction(date, amount, balance);
        transactions.add(transaction);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        String HEADER = "Date                   | Amount  | Balance";
        StringBuilder builder = new StringBuilder();
        builder.append(HEADER);

        for (Transaction t : transactions) {
            builder.append("\n").append(t.toString());
        }

        String result = builder.toString();
        return result;
    }
}
