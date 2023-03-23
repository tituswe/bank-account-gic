package command;

import java.util.Scanner;

import bank.BankAccount;


public class QuitCommand implements Command<BankAccount> {
    @Override
    public void execute(Scanner scanner, BankAccount bankAccount) {
        // Do nothing
    }
}
