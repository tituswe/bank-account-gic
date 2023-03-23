package command;

import java.util.Scanner;

import bank.BankAccount;
import util.Printer;

public class PrintStatementCommand implements Command<BankAccount> {
    @Override
    public void execute(Scanner scanner, BankAccount bankAccount) {
        Printer.print(bankAccount.toString());
    }
}
