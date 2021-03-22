package lab5_1;

import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Customer> customers;

    // constructors


    public Bank(String name) {
        this.name = name;
        customers = new ArrayList<>();
    }

    public Customer getCustomer(int customerId) {
        for (Customer c: customers) {
            if (c.getId() == customerId) {
                return c;
            }
        }
        return null;
    }
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public int numCustomers() {
        return customers.size();
    }

    private void printCustomers(PrintStream ps) {
        ps.println("ID, Firstname, Last name, Number of bank accounts");
        for( Customer customer: customers ){
            ps.println( String.format("%08d",customer.getId())+", " + customer.getFirstName() +", "+
                    customer.getLastName()+", "+customer.getNumAccounts());
        }
    }

    public void printCustomersToStdout() {
        printCustomers(System.out);
    }

    public void printCustomersToFile(String filename) {
        try {
            printCustomers( new PrintStream(filename ));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
