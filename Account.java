package OOP;
import java.util.Objects;

public class Account {
    private String accountNumber;
    private String ownerName;
    private double balance;

    public Account(String accountNumber, String ownerName, double balance) {
        setAccountNumber(accountNumber);
        setOwnerName(ownerName);
        setBalance(balance);
    }

    public void deposit(double depositAmount) {
        if (depositAmount > 0) balance += depositAmount;
        else System.out.println("Invalid amount");
    }

    public void withdraw(double withDrawAmount) {
        if (balance < withDrawAmount){
            System.out.println("NOT ENOUGH BALANCE");
            return;
        }
        if (withDrawAmount > 0) balance -= withDrawAmount;
        else System.out.println("NEGATIVE BALANCE");
    }

    public void setAccountNumber(String accountNumber) {
        if (accountNumber == null || accountNumber.isEmpty() || accountNumber.length() < 4) {
            System.out.println("ERROR!");
            return;
        }
        this.accountNumber = accountNumber;
    }

    public void setOwnerName(String ownerName) {
        if (ownerName == null || ownerName.isEmpty() || ownerName.length() < 3) {
            System.out.println("ERROR!");
            return;
        }
        this.ownerName = ownerName;
    }

    public void setBalance(double balance) {
        if (balance < 0) {
            System.out.println("Balance cannot be negative!");
            return;
        }
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(accountNumber, account.accountNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(accountNumber);
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", balance=" + balance +
                '}';
    }
}

