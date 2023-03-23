package command;

import java.util.Scanner;

public interface Command<T> {
    void execute(Scanner scanner, T t);
}
