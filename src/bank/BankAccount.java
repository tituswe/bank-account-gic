package bank;

import java.util.ArrayList;
import java.util.Date;

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
     * Constructor for the {@code bank.BankAccount} class.
     * Initializes the balance and transactions of the bank account.
     *
     */
    public BankAccount() {
        this.balance = 0;
        this.transactions = new ArrayList<>();
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
        builder.append(HEADER)
                .append("\n");

        for (Transaction t : transactions) {
            builder.append(t.toString())
                    .append("\n");
        }

        String result = builder.toString();
        return result;
    }
}
