package oops_practice.gcr_codebase.Class;

import java.util.ArrayList;
import java.util.List;

public class Bankaccount {
    
    
    private String accountNumber;
    private String holder;
    private double balance;

    private List<String> transactions;

    public static int totalAccounts = 0;

    public BankAccount(String accountNumber, String holder, double balance) {
        this.accountNumber = accountNumber;
        this.holder = holder;
        this.balance = balance;
        this.transactions = new ArrayList<>();

        totalAccounts++;
        transactions.add("Account Created with balance: ₹" + balance);
    }

    public void deposit(double amount) {
        balance += amount;
        transactions.add("Deposited ₹" + amount +
                " | Balance: ₹" + balance);
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            transactions.add("Withdrawal of ₹" + amount +
                    " Failed (Insufficient Balance)");
            System.out.println("Insufficient balance in Account: "
                    + accountNumber);
        } else {
            balance -= amount;
            transactions.add("Withdrawn ₹" + amount +
                    " | Balance: ₹" + balance);
        }
    }

    public void getStatement() {
        System.out.println("\n--------------------------------");
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Holder         : " + holder);
        System.out.println("Balance        : ₹" + balance);

        System.out.println("\nTransaction History:");
        for (String transaction : transactions) {
            System.out.println(transaction);
        }
        System.out.println("--------------------------------");
    }
}
