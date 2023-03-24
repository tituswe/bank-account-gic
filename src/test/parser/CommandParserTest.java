package test.parser;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import bank.command.Command;
import bank.command.DepositCommand;
import bank.command.PrintStatementCommand;
import bank.command.QuitCommand;
import bank.command.WithdrawCommand;
import bank.parser.CommandParser;

class CommandParserTest {

    @Test
    void parse_validDepositCommand_returnsDepositCommand() {
        CommandParser parser = new CommandParser();
        Command command = parser.parse("D");
        assertTrue(command instanceof DepositCommand);
    }

    @Test
    void parse_validWithdrawCommand_returnsWithdrawCommand() {
        CommandParser parser = new CommandParser();
        Command command = parser.parse("W");
        assertTrue(command instanceof WithdrawCommand);
    }

    @Test
    void parse_validPrintStatementCommand_returnsPrintStatementCommand() {
        CommandParser parser = new CommandParser();
        Command command = parser.parse("P");
        assertTrue(command instanceof PrintStatementCommand);
    }

    @Test
    void parse_validQuitCommand_returnsQuitCommand() {
        CommandParser parser = new CommandParser();
        Command command = parser.parse("Q");
        assertTrue(command instanceof QuitCommand);
    }

    @Test
    void parse_invalidInput_throwsIllegalArgumentException() {
        CommandParser parser = new CommandParser();
        assertThrows(IllegalArgumentException.class, () -> parser.parse("X"));
    }

}
