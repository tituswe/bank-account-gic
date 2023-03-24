# Bank Account Application

by Titus Lowe

## Testing Instructions

### System Requirements

* Ensure you have [Java](https://www.oracle.com/sg/java/technologies/downloads/) version 11 or higher installed
* Works on Windows and MacOS

### Testing with CLI
1. Download and extract the `bank-account-gic.zip` file
2. Open **Command Prompt** or **Terminal**
3. Path to the `bank-account-gic` directory saved on your computer
```
cd path/to/bank-account-gic/
```
4. Path to the `src/` directory
```
cd src/
```
5. Compile all java files, compiled in `sources.txt`
```
javac @sources.txt
```
6. Run the program
```
java bank/Main
```

### Testing with IDE
1. Download and extract the `bank-account-gic.zip` file
2. Open **IDE**
3. Select `File > Open` and open the `bank-account-gic` directory
4. Right-click the `Main` class file and click `Run`

## Design Considerations

The `Main` class launches the application, which instantiates a `Bank` object and calls on `Bank#run` to start an 
event loop in the application waiting for user input.

Within the `Bank#run` event loop, each String input into the CLI by the user will be passed through a `CommandParser`.
This `CommandParser` maps the given user input into a `Command`, i.e.:
* 'd' or 'D' --> `DepositCommand`
* 'w' or 'W' --> `WithdrawCommand`
* 'p' or 'P' --> `PrintStatementCommand`
* 'q' or 'Q' --> `QuitCommand`

These commands extend an abstract class `Command` and all override the `Command#execute` method. Utilizing polymorphism
to implement the bank.command execution makes for much neater and more scalable code.

The `Bank` class also contains a `BankAccount` which represents the state of the current bank account. Each `Command`
will alter the state of the `BankAccount` differently, according to their implementation of the `execute()` method.

## Assumptions Made

1. Bank account balance can take on **negative values**, in the case of overdrawing.
2. A user may not **deposit** or **withdraw** a **negative value**
3. The range of any amount transacted is within **-2147483648** to **2147483647**