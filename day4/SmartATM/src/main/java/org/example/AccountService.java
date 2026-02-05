package org.example;

public class AccountService {

    BankAccount account;

    public void createAccount(int accNo, String name, int pin) {
        account = new BankAccount(accNo, name, pin);
        System.out.println("Account created successfully.");
    }

    public BankAccount login(int accNo, int pin) {
        if (account != null &&
                account.accountNumber == accNo &&
                account.validatePin(pin)) {
            return account;
        }
        return null;
    }

    public void deposit(BankAccount acc, double amount) {
        acc.deposit(amount);
        System.out.println("Deposit successful.");
    }

    public void withdraw(BankAccount acc, double amount) {
        if (acc.withdraw(amount)) {
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void showBalance(BankAccount acc) {
        System.out.println("Balance: " + acc.getBalance());
    }

    public void showTransactions(BankAccount acc) {
        acc.showTransactions();
    }
}

