package parser;

import command.Command;
import command.DepositCommand;
import command.PrintStatementCommand;
import command.QuitCommand;
import command.WithdrawCommand;

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
            throw new IllegalArgumentException("Illegal Argument: Enter a command");
        }
    }
}
