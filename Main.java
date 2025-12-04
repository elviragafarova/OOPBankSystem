package OOP;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static Account[] accounts = new Account[3];

    public static void main(String[] args) {

        while (true) {
            System.out.println("1.Create account");
            System.out.println("2.Deposit");
            System.out.println("3.Withdraw");
            System.out.println("4.Run special action");
            System.out.println("5.Show account info");
            System.out.println("0.Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 0) break;
            if (choice == 1) createAccount();
            if (choice == 2) deposit();
            if (choice == 3) withdraw();
            if (choice == 4) specialAction();
            if (choice == 5) showAccountInfo();

            System.out.println(Arrays.toString(accounts));
        }

        sc.close();
    }

    // ----------------------- METHODS -----------------------

    static void createAccount() {
        System.out.println("Enter account number");
        String accountNumber = sc.nextLine();

        System.out.println("Enter owner name");
        String ownerName = sc.nextLine();

        System.out.println("Enter starting balance");
        double startingBalance = sc.nextDouble();
        sc.nextLine();

        System.out.println("Enter account type: 1(loan)/2(deposit)/3(mortgage)");
        int accountType = sc.nextInt();
        sc.nextLine();

        Account account = null;

        if (accountType == 1)
            account = new LoanAccount(accountNumber, ownerName, startingBalance);
        else if (accountType == 2)
            account = new DepositAccount(accountNumber, ownerName, startingBalance);
        else if (accountType == 3)
            account = new MortgageAccount(accountNumber, ownerName, startingBalance);
        else {
            System.out.println("INVALID ACCOUNT TYPE");
            return;
        }

        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] == null) {
                accounts[i] = account;
                System.out.println("Account created!");
                return;
            }
        }
        System.out.println("No empty slot for new account!");
    }

    static void deposit() {
        System.out.println("Enter account number");
        String accountNumber = sc.nextLine();

        System.out.println("Enter deposit amount");
        double amount = sc.nextDouble();
        sc.nextLine();

        for (Account acc : accounts) {
            if (acc != null && acc.getAccountNumber().equals(accountNumber)) {
                acc.deposit(amount);
                return;
            }
        }
        System.out.println("Account not found!");
    }

    static void withdraw() {
        System.out.println("Enter account number");
        String accountNumber = sc.nextLine();

        System.out.println("Enter withdraw amount");
        double amount = sc.nextDouble();
        sc.nextLine();

        for (Account acc : accounts) {
            if (acc != null && acc.getAccountNumber().equals(accountNumber)) {
                acc.withdraw(amount);
                return;
            }
        }
        System.out.println("Account not found!");
    }

    static void specialAction() {
        System.out.println("Enter account number");
        String accountNumber = sc.nextLine();

        for (Account acc : accounts) {
            if (acc != null && acc.getAccountNumber().equals(accountNumber)) {

                if (acc instanceof LoanAccount)
                    ((LoanAccount) acc).chargeInterest();

                else if (acc instanceof DepositAccount)
                    ((DepositAccount) acc).addMonthlyBonus();

                else if (acc instanceof MortgageAccount)
                    ((MortgageAccount) acc).addMonthlyFee();

                return;
            }
        }
        System.out.println("Account not found!");
    }

    static void showAccountInfo() {
        System.out.println("Enter account number");
        String accountNumber = sc.nextLine();

        for (Account acc : accounts) {
            if (acc != null && acc.getAccountNumber().equals(accountNumber)) {
                System.out.println(acc);
                return;
            }
        }
        System.out.println("Account not found!");
    }
}
