package OOP;

public class MortgageAccount extends Account {
    public MortgageAccount(String accountNumber, String ownerName, double balance) {
        super(accountNumber, ownerName, balance);
    }

    public void addMonthlyFee() {
        setBalance(getBalance() - 10);
        if (getBalance() < 0) System.out.println("BALANCE IS GOING TO NEGATIVE");
    }
}
