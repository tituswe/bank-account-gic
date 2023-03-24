package bank.parser;

import bank.command.Command;
import bank.command.DepositCommand;
import bank.command.PrintStatementCommand;
import bank.command.QuitCommand;
import bank.command.WithdrawCommand;

/**
 * Parses the user input into a command.
 */
public class CommandParser {

    /**
     * Parses the user input into a command for execution.
     *
     * @param input User input
     * @return The command to be executed, based on the input
     */
    public Command parse(String input) {
        input = input.toUpperCase();

        switch (input) {
        case "D":
            return new DepositCommand();
        case "W":
            return new WithdrawCommand();
        case "P":
            return new PrintStatementCommand();
        case "Q":
            return new QuitCommand();
        default:
            throw new IllegalArgumentException("Illegal Argument: Enter a main.command");
        }
    }
}
