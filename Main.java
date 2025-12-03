package OOP;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account[] accounts = new Account[3];

        while (true) {
            System.out.println("1.Create account");
            System.out.println("2.Deposit ");
            System.out.println("3.Withdraw");
            System.out.println("4. Run special action");
            System.out.println("5. Show account info");
            System.out.println("0.Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 0) break;

            if (choice == 1) {
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
                if(accountType == 1) {
                    account = new LoanAccount(accountNumber, ownerName, startingBalance);
                }else if (accountType == 2) {
                    account = new DepositAccount(accountNumber, ownerName, startingBalance);
                }else if(accountType == 3) {
                    account = new MortgageAccount(accountNumber, ownerName, startingBalance);

                }else {
                    System.out.println("INVALID ACCOUNT TYPE");
                }

                for(int i = 0; i < accounts.length; i++) {
                    if(accounts[i] == null) {
                    accounts[i] = account;
                    break;
                    }
                }
            }

            if(choice == 2) {
                System.out.println("Enter account number");
                String accountNumber = sc.nextLine();

                System.out.println("Enter deposit amount ");
                double depositAmount = sc.nextDouble();
                sc.nextLine();
                int i;

                for( i = 0; i < accounts.length; i++) {
                    if(accounts[i] != null && accounts[i].getAccountNumber().equals(accountNumber)  ) {
                        accounts[i].deposit(depositAmount);
                        break;
                    }    }
                if( i==accounts.length) System.out.println("Account not found!");
            }


            if(choice == 3) {
                System.out.println("Enter account number");
                String accountNumber = sc.nextLine();

                System.out.println("Enter withdraw amount ");
                double withDrawAmount = sc.nextDouble();
                sc.nextLine();

                int i;

                for( i = 0; i < accounts.length; i++) {
                    if(accounts[i] != null && accounts[i].getAccountNumber().equals(accountNumber)   ) {
                        accounts[i].withdraw(withDrawAmount);
                        break;
                    }
                }
                if( i==accounts.length) System.out.println("Account not found!");
            }

            if(choice == 4) {
                System.out.println("Enter account number");
                String accountNumber = sc.nextLine();

                int i;

                for ( i = 0; i < accounts.length; i++) {

                    if (accounts[i] != null && accounts[i].getAccountNumber().equals(accountNumber)) {

                        if (accounts[i] instanceof LoanAccount) {
                            ((LoanAccount) accounts[i]).chargeInterest();
                        }
                        else if (accounts[i] instanceof DepositAccount) {
                            ((DepositAccount) accounts[i]).addMonthlyBonus();
                        }
                        else if (accounts[i] instanceof MortgageAccount) {
                            ((MortgageAccount) accounts[i]).addMonthlyFee();
                        }
                        break;
                    }
                }
                if( i==accounts.length) System.out.println("Account not found!");
            }

            if(choice == 5){
                System.out.println("Enter account number");
                String accountNumber = sc.nextLine();

                int i;
                for (i = 0; i < accounts.length; i++) {

                    if (accounts[i] != null &&
                            accounts[i].getAccountNumber().equals(accountNumber)) {

                        System.out.println(accounts[i]);
                        break;
                    }
                }
                if( i==accounts.length) System.out.println("Account not found!");

            }

            System.out.println(Arrays.toString(accounts));

        }
        sc.close();


    }
}
