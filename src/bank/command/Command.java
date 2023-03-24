package bank.command;

import java.util.Scanner;

import bank.model.BankAccount;

/**
 * Represents a command with hidden internal logic and the ability to be executed.
 */
public abstract class Command {

    /**
     * Executes the command.
     *
     * @param scanner The scanner being used in the program
     * @param bankAccount The bank account
     */
    public abstract void execute(Scanner scanner, BankAccount bankAccount);
}
