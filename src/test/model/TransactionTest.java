package test.model;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import bank.model.Transaction;

public class TransactionTest {
    private Transaction transaction;
    private Date date;
    private double amount;
    private double balance;
    private SimpleDateFormat dateFormat;

    @Before
    public void setUp() throws Exception {
        // Set up a new transaction with a known date, amount, and balance
        date = new Date();
        amount = 100.0;
        balance = 200.0;
        transaction = new Transaction(date, amount, balance);

        // Set up a date format for testing toString()
        dateFormat = new SimpleDateFormat("d MMM yyyy hh:mm:ssa");
    }

    @Test
    public void getDate_returnsDate() {
        assertEquals(date, transaction.getDate());
    }

    @Test
    public void getAmount_returnsAmount() {
        assertEquals(amount, transaction.getAmount(), 0.001);
    }

    @Test
    public void getBalance_returnsBalance() {
        assertEquals(balance, transaction.getBalance(), 0.001);
    }

    @Test
    public void toString_positiveAmount_returnsString() {
        String expected = dateFormat.format(date) + " | 100.00  | 200.00";
        assertEquals(expected, transaction.toString());
    }

    @Test
    public void toString_negativeAmount_returnsString() {
        double negativeAmount = -50.0;
        double expectedBalance = balance + negativeAmount;
        Transaction negativeTransaction = new Transaction(date, negativeAmount, expectedBalance);

        String expected = dateFormat.format(date) + " | -50.00 | 150.00";
        assertEquals(expected, negativeTransaction.toString());
    }
}
