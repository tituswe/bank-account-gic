package bank;

import java.util.Scanner;

import command.Command;
import command.QuitCommand;
import parser.CommandParser;
import util.Printer;

/**
 * The bank class.
 */
public class Bank {
    private final String GREETING = "Welcome to AwesomeGIC Bank! What would you like to do?\n"
            + "[D]eposit \n"
            + "[W]ithdraw\n"
            + "[P]rint statement\n"
            + "[Q]uit";
    private final String FAREWELL = "Thank you for banking with AwesomeGIC Bank.\n"
            + "Have a nice day!";
    /**
     * A boolean flag to check the active state of the application.
     */
    private static boolean isActive;
    /**
     * An instance of the {@code parser.CommandParser}, used to parse input into commands.
     */
    private CommandParser commandParser;
    /**
     * An instance of the {@code BankAccount}, used to facilitate actions.
     */
    private BankAccount bankAccount;

    /**
     * Constructor for the {@code Bank} class.
     * Initializes the active state, storage and bank account for the application.
     *
     */
    public Bank() {
        isActive = true;
        commandParser = new CommandParser();
        bankAccount = new BankAccount();
    }

    /**
     * The main loop for the Bank application.
     * This method runs an event loop which takes in command inputs from the command line.
     */
    public void run() {
        Scanner scanner = new Scanner(System.in);
        Printer.print(GREETING);

        while (isActive) {
            String input = scanner.nextLine();
            Printer.space();
            try {
                Command command = commandParser.parse(input);
                if (command instanceof QuitCommand) {
                    isActive = false;
                }
                command.execute(scanner, bankAccount);
            } catch (IllegalArgumentException e) {
                Printer.print(e.getMessage());
            }
        }

        Printer.print(FAREWELL);
    }
}
