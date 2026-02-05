package org.example;

public class BankAccount {

    int accountNumber;
    String name;
    private int pin;
    private double balance;

    Transaction[] transactions = new Transaction[10];
    int transactionCount = 0;

    public BankAccount(int accountNumber, String name, int pin) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.pin = pin;
        this.balance = 0;
    }

    public boolean validatePin(int enteredPin) {
        return pin == enteredPin;
    }

    public void deposit(double amount) {
        balance += amount;
        transactions[transactionCount++] =
                new Transaction("DEPOSIT", amount);
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            transactions[transactionCount++] =
                    new Transaction("WITHDRAW", amount);
            return true;
        }
        return false;
    }

    public double getBalance() {
        return balance;
    }

    public void showTransactions() {
        for (int i = 0; i < transactionCount; i++) {
            System.out.println(transactions[i].type + " | " + transactions[i].amount + " | " +
                    transactions[i].date);
        }
    }
}

