package test.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

import bank.model.Bank;

public class BankTest {

    private Bank bank;

    @Before
    public void setUp() {
        bank = new Bank();
    }

    @After
    public void tearDown() {
        bank = null;
    }

    @Test
    public void testDepositCommand_updatesBalance() {
        String input = "d\n100\nq\n";
        InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);
        bank.run();
        assertEquals(100.0, bank.getBankAccount().getBalance(), 0.0);
    }

    @Test
    public void testWithdrawCommand_updatesBalance() {
        String input = "d\n100\nw\n50\nq\n";
        InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);
        bank.run();
        assertEquals(50.0, bank.getBankAccount().getBalance(), 0.0);
    }

    @Test
    public void testPrintStatementCommand() {
        String input = "d\n100\np\nq\n";
        InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);
        bank.run();
        String actualOutput = bank.getBankAccount().toString();

        SimpleDateFormat dateFormat = new SimpleDateFormat("d MMM yyyy hh:mm:ssa");
        Date date = new Date();
        String formattedDate = dateFormat.format(date);
        String expectedOutput = "Date                   | Amount  | Balance\n"
                +  formattedDate + " | 100.00  | 100.00";
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testQuitCommand_terminate() {
        String input = "q\n";
        InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);
        bank.run();
        assertFalse(bank.getIsActive());
    }
}
