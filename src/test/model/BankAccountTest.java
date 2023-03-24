package test.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import bank.model.BankAccount;
import bank.model.Transaction;

public class BankAccountTest {

    private BankAccount bankAccount;

    @BeforeEach
    public void setUp() {
        bankAccount = new BankAccount();
    }

    @Test
    public void getBalance_returnsBalance() {
        double expected = 0.0;
        double actual = bankAccount.getBalance();
        assertEquals(expected, actual);
    }

    @Test
    public void transact_updatesBankAccount() {
        double amount = 100.0;
        double expectedBalance = 100.0;
        double expectedTransactionAmount = 100.0;

        bankAccount.transact(amount);

        double actualBalance = bankAccount.getBalance();
        assertEquals(expectedBalance, actualBalance);

        ArrayList<Transaction> transactions = getTransactions();
        assertEquals(1, transactions.size());

        Transaction transaction = transactions.get(0);
        Date date = transaction.getDate();
        double actualTransactionAmount = transaction.getAmount();
        double actualTransactionBalance = transaction.getBalance();

        assertEquals(amount, actualTransactionAmount);
        assertEquals(expectedTransactionAmount, actualTransactionAmount);
        assertEquals(expectedBalance, actualTransactionBalance);
    }

    @Test
    public void toString_returnsString() {
        bankAccount.transact(500.0);
        bankAccount.transact(-100.0);

        SimpleDateFormat dateFormat = new SimpleDateFormat("d MMM yyyy hh:mm:ssa");
        String expected = "Date                   | Amount  | Balance\n" +
                dateFormat.format(new Date()) + " | 500.00  | 500.00\n" +
                dateFormat.format(new Date()) + " | -100.00 | 400.00";

        String actual = bankAccount.toString();
        assertEquals(expected, actual);
    }

    private ArrayList<Transaction> getTransactions() {
        try {
            java.lang.reflect.Field field = bankAccount.getClass().getDeclaredField("transactions");
            field.setAccessible(true);
            return (ArrayList<Transaction>) field.get(bankAccount);
        } catch (Exception e) {
            fail("Failed to get transactions list");
            return null;
        }
    }

    private String formatDate(Date date) {
        return String.format("%1$td/%1$tm/%1$tY", date);
    }
}
