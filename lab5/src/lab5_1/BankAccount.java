package lab5_1;

public class BankAccount {
    public static final String PREFIX = "OTP";
    public static final int ACCOUNT_NUMBER_LENTH = 10;
    private static int numAccounts = 0; // default value = 0.
    private final String accountNumber;
    private double balance;  // default value = 0.


    // Constructor
    public BankAccount() {
        ++numAccounts;
        this.accountNumber = generateAccountNumber();
    }

    private static String generateAccountNumber() {
        // returns the string of latest account number
        String str = Integer.toString(numAccounts);
        return PREFIX + "0".repeat(ACCOUNT_NUMBER_LENTH - PREFIX.length() - str.length()) + str;
    }


    public String createAccountNumber() {
        return generateAccountNumber();
    }

    // no parameters
    // but has return type
    public String getAccountNumber() {
        return this.accountNumber;
    }

    public double getBalance() {
        return this.balance;
    }

    public void deposit(double amount) {
        // 預金
        if (0 < amount) {
            balance += amount;
        }
    }

    public boolean withdraw(double amount) {
        // 引き出し
        if (balance < amount) {
            return false;
        }
        balance -= amount;
        return true;
    }

    @Override
    public String toString() {
        return "lab5_1.Customer.BankAccount{" +
                "accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                '}';
    }
}
