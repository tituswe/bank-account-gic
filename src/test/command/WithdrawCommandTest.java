package test.command;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import bank.command.WithdrawCommand;
import bank.model.BankAccount;

public class WithdrawCommandTest {

    @Test
    public void execute_validInput_updatesBalance() {
        String input = "100\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);

        BankAccount bankAccount = new BankAccount();
        double initialBalance = bankAccount.getBalance();

        WithdrawCommand withdrawCommand = new WithdrawCommand();
        withdrawCommand.execute(scanner, bankAccount);

        double expectedAmount = 100;
        double expectedBalance = initialBalance - expectedAmount;
        double actualBalance = bankAccount.getBalance();

        Assertions.assertEquals(expectedBalance, actualBalance);
    }

    @Test
    public void execute_zeroInput_doesNothing() {
        String input = "0\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);

        BankAccount bankAccount = new BankAccount();
        double initialBalance = bankAccount.getBalance();

        WithdrawCommand withdrawCommand = new WithdrawCommand();
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> withdrawCommand.execute(scanner, bankAccount));

        double actualBalance = bankAccount.getBalance();

        Assertions.assertEquals(initialBalance, actualBalance);
    }

    @Test
    public void execute_negativeInput_doesNothing() {
        String input = "-50\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);

        BankAccount bankAccount = new BankAccount();
        double initialBalance = bankAccount.getBalance();

        WithdrawCommand withdrawCommand = new WithdrawCommand();
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> withdrawCommand.execute(scanner, bankAccount));

        double actualBalance = bankAccount.getBalance();

        Assertions.assertEquals(initialBalance, actualBalance);
    }

    @Test
    public void execute_nonNumericInput_doesNothing() {
        String input = "abc\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);

        BankAccount bankAccount = new BankAccount();
        double initialBalance = bankAccount.getBalance();

        WithdrawCommand withdrawCommand = new WithdrawCommand();
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> withdrawCommand.execute(scanner, bankAccount));

        double actualBalance = bankAccount.getBalance();

        Assertions.assertEquals(initialBalance, actualBalance);
    }
}
