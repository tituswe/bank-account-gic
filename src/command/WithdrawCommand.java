package command;

import java.util.Scanner;

import bank.BankAccount;
import util.Printer;


public class WithdrawCommand implements Command<BankAccount> {
    private final String REQUEST_AMOUNT = "Please enter the amount to withdraw:\n";
    private final String RESPONSE = "Thank you. $%.2f has been withdrawn.\n"
            + "Is there anything else you'd like to do?\n"
            + "[D]eposit \n"
            + "[W]ithdraw\n"
            + "[P]rint statement\n"
            + "[Q]uit\n";
    @Override
    public void execute(Scanner scanner, BankAccount bankAccount) {
        Printer.print(REQUEST_AMOUNT);
        String input = scanner.nextLine();
        Printer.print("");

        try {
            double amount = Double.parseDouble(input);
            bankAccount.transact(-1 * amount);

            String response = String.format(RESPONSE, amount);
            Printer.print(response);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Illegal Argument: Enter a number\n");
        }
    }
}
