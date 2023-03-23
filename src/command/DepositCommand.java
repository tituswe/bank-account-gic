package command;

import java.util.Scanner;

import bank.BankAccount;
import util.Printer;

/**
 * Makes a deposit into the bank account.
 */
public class DepositCommand extends Command {
    private final String REQUEST_AMOUNT = "Please enter the amount to deposit:";
    private final String RESPONSE = "Thank you. $%.2f has been deposited to your account.\n"
            + "Is there anything else you'd like to do?\n"
            + "[D]eposit \n"
            + "[W]ithdraw\n"
            + "[P]rint statement\n"
            + "[Q]uit";
    @Override
    public void execute(Scanner scanner, BankAccount bankAccount) {
        Printer.print(REQUEST_AMOUNT);
        String input = scanner.nextLine();
        Printer.space();

        try {
            double amount = Double.parseDouble(input);
            if (amount <= 0) {
                throw new IllegalArgumentException("Illegal Argument: Enter a value greater than 0");
            }
            bankAccount.transact(amount);

            String response = String.format(RESPONSE, amount);
            Printer.print(response);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Illegal Argument: Enter a number");
        }
    }
}
