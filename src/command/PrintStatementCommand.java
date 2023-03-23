package command;

import java.util.Scanner;

import bank.BankAccount;
import util.Printer;

/**
 * Makes a print statement of the bank account's recent transactions.
 */
public class PrintStatementCommand extends Command {
    @Override
    public void execute(Scanner scanner, BankAccount bankAccount) {
        Printer.print(bankAccount.toString());
    }
}
