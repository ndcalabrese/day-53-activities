import java.util.ArrayList;

public class BankAccount {
    // Declare private variables.
    private int accNumber;
    private String accHolderName;
    private double accBalance;

    // Class constructor
    public BankAccount(int accNumber, String custName, double custBalance) {
        this.accNumber = accNumber;
        this.accHolderName = custName;
        this.accBalance = custBalance;
    }

    // Class constructor with no parameters for new bank account
    public BankAccount() {
        System.out.println("\nLet's create a new bank account!\n");
        System.out.print("What's the name of the account holder?: ");

        double accInitialBalance;

        this.accHolderName = AccountManager.getUserInput();

        while (true) {
            System.out.print("\nWhat is the initial deposit amount?: ");
            String userInputBalance = AccountManager.getUserInput();

            // Check if user input is a number, and if it is, check if the
            // number is greater than zero
            if (AccountManager.isNumeric(userInputBalance)) {
                accInitialBalance = Double.parseDouble(userInputBalance);
                if (accInitialBalance > 0) {
                    this.accBalance = accInitialBalance;
                    break;
                } else {
                    System.out.println("\nPlease enter a number greater than zero.");
                }
            } else {
                System.out.println("\nInvalid entry.");
            }
        }


    }

    // Return to main menu
    public void mainMenu(ArrayList<BankAccount> accountList, BankAccount selectedAccount) {
        AccountManager.manageAccount(accountList, selectedAccount);
    }

    // Prints balance of account by calling our custom toString() method.
     public void showBalance() {
         System.out.println("\n" + this);
     }

     // Deposits specified amount into account.
    public void deposit(double depositAmt) {
        this.accBalance += depositAmt;
    }

    // Withdraws specified amount from account.
    // Returns withdrawal amount to be used as deposit amount during
    // a transfer of funds.
    public double withdrawal(double withdrawalAmt) {
        this.accBalance -= withdrawalAmt;

        return withdrawalAmt;
    }

    // Transfer specified amount to specified recipient account.
    // Show balances of sender and recipients' accounts afterwards.
    public void transfer(double transferAmt, BankAccount recipient) {
        recipient.deposit(this.withdrawal(transferAmt));
        showBalance();
        recipient.showBalance();
    }

    // Round doubles to two decimal places, because money.
    public String roundAmt(double amount) {
        return String.format("%,.2f", amount);
    }

    // SETTERS

    // Set account number
    public void setAccNumber(int accNumber) {
        this.accNumber = accNumber;
    }

    // Set name of account holder
    public void setAccHolderName(String accHolderName) {
        this.accHolderName = accHolderName;
    }

    // Set initial account balance
    public void setAccBalance(double initialBalance) {
        this.accBalance = initialBalance;
    }

    // GETTERS

    // Return account number
    public String getAccNumber() {
        return String.valueOf(this.accNumber);
    }

    // Return name of account holder
    public String getAccHolderName() {
        return this.accHolderName;
    }

    public double getAccBalance() {
        return this.accBalance;
    }

    // Check if account has sufficient funds for withdrawals
    // and transfers.
    public boolean hasInsufficientFunds(double amount) {
        return amount > getAccBalance();
    }

    // Override the toString() method so that it returns a string
    // containing the account holder's name and balance.
    @Override
    public String toString () {
        return "The account balance of account for " + getAccHolderName() + " is $" + roundAmt(getAccBalance());
    }

}
