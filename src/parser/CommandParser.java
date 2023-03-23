package parser;

import command.*;
import parser.Parser;

public class CommandParser implements Parser<Command> {
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
            throw new IllegalArgumentException("Illegal Argument: Enter a command\n");
        }
    }
}
