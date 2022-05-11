import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class AccountManager {
    public static void main(String[] args) {

        // Create list of accounts using an ArrayList.
        ArrayList<BankAccount> accountList = new ArrayList<>();

        // Instantiate new bank accounts.
        BankAccount account1 = new BankAccount(1, "Nick", 5_00);
        BankAccount account2 = new BankAccount(2, "Larry", 5_000);
        BankAccount account3 = new BankAccount(3, "Mary", 300);
        BankAccount account4 = new BankAccount(4, "Bill", 99_999_999);

        // Add bank accounts to list of accounts.
        Collections.addAll(accountList, account1, account2, account3, account4);

        // Display "main menu" to see if customer has an account
        if (welcomeUser()) {
            manageAccount(accountList, selectAccount(accountList, false));
        } else {
            accountList.add(createAccount(accountList));
            manageAccount(accountList, selectAccount(accountList, false));
        }

    }

    public static boolean welcomeUser() {
        System.out.println("""
                        
                        W E L C O M E    T O     T H E       \s
                 _____ _____ _____ _____    _____ _____ _____\s
                | __  |  _  |   | |  |  |  |  _  |  _  |  _  |
                | __ -|     | | | |    -|  |     |   __|   __|
                |_____|__|__|_|___|__|__|  |__|__|__|  |__|  \s
                                                             \s
                """);
        System.out.println("""
                Are you an existing customer?
                1 - Yes
                2 - No""");

        boolean userHasAcc = false;

        while (true) {
            System.out.print("\nResponse: ");
            String userInput = getUserInput();
            if (userInput.equals("1")) {
                userHasAcc = true;
                break;
            } else if (userInput.equals("2")) {
                break;
            } else {
                System.out.println("\nInvalid response.");
            }
        }

        return userHasAcc;
    }

    public static BankAccount createAccount(ArrayList<BankAccount> accountList) {
        System.out.println("\nLet's create a new bank account!\n");
        System.out.print("What's the name of the account holder?: ");
        BankAccount newAccount = new BankAccount();
        double accInitialBalance;

        newAccount.setAccHolderName(getUserInput());

        while (true) {
            System.out.print("\nWhat is the initial deposit amount?: ");
            String userInputBalance = getUserInput();

            if (isNumeric(userInputBalance)) {
                accInitialBalance = Double.parseDouble(userInputBalance);
                if (accInitialBalance > 0) {
                    newAccount.setAccBalance(accInitialBalance);
                    break;
                } else {
                    System.out.println("\nPlease enter a number greater than zero.");
                }
            } else {
                System.out.println("\nInvalid entry.");
            }
        }

        newAccount.setAccNumber((accountList.size() + 1));

        return newAccount;
    }

    // Provide user with the list of accounts and allow them to select
    // an account based on their input.
    public static BankAccount selectAccount(ArrayList<BankAccount> accountList, boolean isTransfer) {
        String selectedAccount;

        System.out.println("List of accounts:");

        // Iterate through the ArrayList of BankAccount objects and print
        // the name of the account holder and the balance of each account.
        for (int i = 1; i <= accountList.size(); i++) {
            BankAccount account = accountList.get(i - 1);
            System.out.println("Account #" + account.getAccNumber() +": " + account.getAccHolderName() + " - " + account);
        }
        System.out.println("\n");

        // Show a different message depending on if account is being selected
        // for the first time, or as a recipient for a transfer of funds.
        String messageString = (isTransfer) ? "Please select a recipient: " : "Please select an account: ";
        System.out.print(messageString);

        // Obtain user input for account number.
        // If user input does not correspond to an existing account
        // tell user that entry was invalid.
        while (true) {
            selectedAccount = getUserInput();
            if (isNumeric(selectedAccount)) {
                int accNum = Integer.parseInt(selectedAccount);
                if (accNum > 0 && accNum <= accountList.size()) {
                    break;
                } else {
                        System.out.println("\nInvalid entry. Account does not exist.");
                }
            } else {
                System.out.println("\nInvalid entry. Please enter a number.");
            }
        }

        // Returns account object from list of accounts that corresponds to
        // the user input
        return accountList.get(Integer.parseInt(selectedAccount) - 1);
    }
    public static void manageAccount(ArrayList<BankAccount> accountList, BankAccount selectedAccount) {

        int action;
        String amountString;
        double amount = 0;

        System.out.println("Welcome back, " + selectedAccount.getAccHolderName() + "!");
        System.out.println("""
                
                What would you like to do?
                
                1 - Show my account balance
                2 - Deposit an amount
                3 - Withdraw an amount
                4 - Transfer an amount
                5 - Select another account
                0 - Exit
                """);
        System.out.print("Choose an option: ");

        while (true) {
            String userInput = getUserInput();

            if (isNumeric(userInput)) {
                int userInputInt = Integer.parseInt(userInput);
                if (userInputInt >= 0 && userInputInt <= 5) {
                    action = userInputInt;
                    break;
                } else {
                    System.out.println("\nInvalid entry.");
                }
            } else {
                System.out.println("\nInvalid entry. Please enter a number.");
            }
        }

        // If user chooses to deposit money, withdraw money, or
        // transfer money, return the appropriate message
        if (action == 2 || action == 3 || action == 4) {
            String actionWord = (action == 2)
                    ? "deposit"
                    : (action == 3
                        ? "withdraw"
                        : "transfer"
            );
            while (true) {
                System.out.print("\nPlease enter an amount to " + actionWord + ": $" );
                amountString = getUserInput();

                if (!isNumeric(amountString)) {
                    System.out.println("Invalid entry. Please enter an amount.");
                } else {
                    amount = Double.parseDouble(amountString);
                    if (amount < 0 ) {
                        System.out.println("Invalid entry. Please enter an amount.");
                    } else {
                        break;
                    }
                }
            }
        }

        doAcctAction(action, amount, accountList, selectedAccount);

    }

    public static String getUserInput() {
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }

    public static void doAcctAction(int action, double amount,
                                    ArrayList<BankAccount> accountList,
                                    BankAccount selectedAccount) {
        switch (action) {
            case 1 -> {
                selectedAccount.showBalance();
                selectedAccount.mainMenu(accountList, selectedAccount);
            }
            case 2 -> {
                selectedAccount.deposit(amount);
                selectedAccount.showBalance();
                selectedAccount.mainMenu(accountList, selectedAccount);
            }
            case 3 -> {
                if (selectedAccount.hasInsufficientFunds(amount)) {
                    System.out.println("\nInsufficient funds.");
                    selectedAccount.showBalance();
                    System.out.println("\n");
                    selectedAccount.mainMenu(accountList, selectedAccount);
                } else {
                    selectedAccount.withdrawal(amount);
                }
                selectedAccount.showBalance();
                selectedAccount.mainMenu(accountList, selectedAccount);
            }
            case 4 -> {
                if (selectedAccount.hasInsufficientFunds(amount)) {
                    System.out.println("\nInsufficient funds.");
                    selectedAccount.showBalance();
                    System.out.println("\n");
                    selectedAccount.mainMenu(accountList, selectedAccount);
                } else {
                    selectedAccount.transfer(amount, selectAccount(accountList, true));
                    selectedAccount.mainMenu(accountList, selectedAccount);
                }
            }
            case 5 -> selectedAccount.mainMenu(accountList, selectAccount(accountList, false));
            case 0 -> {System.out.println("\nGoodbye!\n");
                System.exit(0);
            }
        }
    }

    // Checks to see if an input string is a valid double
    // and returns a boolean
    public static boolean isNumeric(String amountInput) {
        try {
            Double.parseDouble(amountInput);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }

}
