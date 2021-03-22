package lab5_1;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        // test 1
        {
            System.out.println("---------Test1--------------");
            ArrayList<BankAccount> accounts = new ArrayList<>();
            for (int i = 0; i < 150; i++) {
                BankAccount account = new BankAccount();
                accounts.add(account);
                System.out.print(account + "  ");
                if (i % 3 == 2) {
                    System.out.println();
                }
            }
        }
        // test 2
//        {
//            System.out.println("---------Test2--------------");
//            ArrayList<BankAccount> accounts = new ArrayList<>();
//            ArrayList<Customer> customers = new ArrayList<>();
//            Customer customer;
//            customer = new Customer("Takahiro", "FUJIWARA");
//            customers.add(customer);
//            customer.addAccount(new BankAccount());
//            customer.addAccount(new BankAccount());
//            customer = new Customer("Aaa", "AAAA");
//            customers.add(customer);
//            customer.addAccount(new BankAccount());
//            customer.addAccount(new BankAccount());
//            customer = new Customer("Bbb", "BBBB");
//            customers.add(customer);
//            customer.addAccount(new BankAccount());
//            customer.addAccount(new BankAccount());
//            System.out.println("---Print the customers");
//            for (int i = 0; i < customers.size(); i++) {
//                System.out.println(customers.get(i));
//            }
//        }
        //test 3
        {
            int custId;
            Random random = new Random();

            System.out.println("---------Test3-----------");
            Customer customer;
            Bank bank = new Bank("OTP");
            customer = new Customer("Takahiro", "FUJIWARA");
            bank.addCustomer(customer);
            customer.addAccount( new BankAccount() );
            customer.addAccount( new BankAccount() );
            customer = new Customer("FirstName", "LastName");
            bank.addCustomer(customer);
            customer.addAccount( new BankAccount() );
            customer.addAccount( new BankAccount() );
            customer.addAccount( new BankAccount() );

            custId = 1;
            System.out.println("**printCustomer before deposit");
            bank.getCustomer(custId).printCustomerToStdout();
            for (String s: bank.getCustomer(custId).getAccountNumbers() ) {
                bank.getCustomer(custId).getAccount(s).deposit(random.nextInt(10)*100+50);
            }
            System.out.println("**printCustomer after deposit");
            bank.getCustomer(custId).printCustomerToStdout();

            custId = 2;
            System.out.println("**printCustomer before deposit");
            bank.getCustomer(custId).printCustomerToStdout();
            for (String s: bank.getCustomer(custId).getAccountNumbers() ) {
                bank.getCustomer(custId).getAccount(s).deposit(random.nextInt(10)*1000+500);
            }
            System.out.println("**printCustomer after deposit");
            bank.getCustomer(custId).printCustomerToStdout();

            bank.printCustomersToStdout();
            bank.printCustomersToFile("bank_customers.csv");
        }
    }
}
