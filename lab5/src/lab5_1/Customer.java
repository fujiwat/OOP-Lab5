package lab5_1;

import javax.lang.model.element.NestingKind;
import java.io.PrintStream;
import java.util.ArrayList; // import the ArrayList class

public class Customer {
    // data
    private static int counter = 0;
    private final int id;
    private String firstName;
    private String lastName;
    private ArrayList<BankAccount> accounts = new ArrayList<>();
//    private BankAccount[] accounts = new BankAccount[MAX_ACCOUNTS];

    // constructor

    public Customer(String firstName, String lastName) {
        id = ++counter;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getNumAccounts() {
        return accounts.size();
    }

    public ArrayList<String> getAccountNumbers() {
        ArrayList<String> accountNumbers = new ArrayList<>();
        for (BankAccount b: accounts) {
            accountNumbers.add(b.getAccountNumber());
        }
        return accountNumbers;
    }

    public BankAccount getAccount(String accountNumber) {
        for (int i = 0; i < getNumAccounts(); i++) {
            if (accounts.get(i).getAccountNumber().equals(accountNumber)) {
                return accounts.get(i); // found.
            }
        }
        System.out.println("** getAccount():  account not found: " + accountNumber);
        return null;                    // not found.
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean addAccount(BankAccount account) {
        this.accounts.add(account);
        return true;  // succeeded.
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean closeAccount(String accountNumber) {
        for (int i = 0; i < getNumAccounts(); i++) {
            if (accounts.get(i) != null) {
                if (accounts.get(i).getAccountNumber().equals(accountNumber)) {
                    System.out.println("   account closed:  " + accountNumber);
                    accounts.remove(i);
                    return true;        // succeeded to close.
                }
            }
        }
        return false;                   // account not found.
    }

    private void printCustomer(PrintStream ps) {
        ps.println("ID, Firstname, Last name, Number of bank accounts");
        ps.println(String.format("%08d", this.getId()) + ", " + this.getFirstName() + ", " +
                this.getLastName() + ", " + this.getNumAccounts());
        for( BankAccount a: accounts ){
            ps.println( "  " + a.getAccountNumber()+ ", Balance=" + a.getBalance() );
        }
    }

    public void printCustomerToStdout() {
        printCustomer(System.out);
    }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        str.append(String.format("%010d: ", id));
        str.append(firstName + " " + lastName + " accounts:\n");
        if (getNumAccounts() == 0) {
            str.append("   No accounts\n");
            return str.toString();
        }
        for (int i = 0; i < getNumAccounts(); i++) {
            str.append("   " + accounts.get(i).toString() + "\n");
        }
        return str.toString();
    }
}
