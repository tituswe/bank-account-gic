package test.command;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import bank.command.PrintStatementCommand;
import bank.model.BankAccount;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrintStatementCommandTest {
    private PrintStatementCommand command;
    private BankAccount bankAccount;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setup() {
        command = new PrintStatementCommand();
        bankAccount = new BankAccount();
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void testExecute_PrintsCorrectStatement() {
        bankAccount.transact(500);
        bankAccount.transact(-100);
        command.execute(new Scanner(""), bankAccount);

        SimpleDateFormat dateFormat = new SimpleDateFormat("d MMM yyyy hh:mm:ssa");
        String formattedDate = dateFormat.format(new Date());
        String expectedOutput = "Date                   | Amount  | Balance\n"
                + formattedDate + " | 500.00  | 500.00\n"
                + formattedDate + " | -100.00 | 400.00\n"
                + "\n";
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void testExecute_PrintsEmptyStatement() {
        command.execute(new Scanner(""), bankAccount);
        String expectedOutput = "Date                   | Amount  | Balance\n"
                + "\n";
        assertEquals(expectedOutput, outputStream.toString());
    }
}