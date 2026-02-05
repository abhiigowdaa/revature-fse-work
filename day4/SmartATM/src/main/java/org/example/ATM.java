package org.example;

import java.util.Scanner;

public class ATM {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        AccountService service = new AccountService();

        while (true) {
            System.out.println("\n1. Create Account");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter Account Number: ");
                int accNo = sc.nextInt();

                System.out.print("Enter Name: ");
                String name = sc.next();

                System.out.print("Set PIN: ");
                int pin = sc.nextInt();

                service.createAccount(accNo, name, pin);
            }

            else if (choice == 2) {
                System.out.print("Enter Account Number: ");
                int accNo = sc.nextInt();

                System.out.print("Enter PIN: ");
                int pin = sc.nextInt();

                BankAccount acc = service.login(accNo, pin);

                if (acc != null) {
                    boolean loggedIn = true;

                    while (loggedIn) {
                        System.out.println("\n1. Deposit");
                        System.out.println("2. Withdraw");
                        System.out.println("3. Check Balance");
                        System.out.println("4. Transactions");
                        System.out.println("5. Logout");

                        int opt = sc.nextInt();

                        if (opt == 1) {
                            service.deposit(acc, sc.nextDouble());
                        }
                        else if (opt == 2) {
                            service.withdraw(acc, sc.nextDouble());
                        }
                        else if (opt == 3) {
                            service.showBalance(acc);
                        }
                        else if (opt == 4) {
                            service.showTransactions(acc);
                        }
                        else if (opt == 5) {
                            loggedIn = false;
                            System.out.println("Logged out.");
                        }
                    }
                } else {
                    System.out.println("Invalid login.");
                }
            }

            else if (choice == 3) {
                System.out.println("Thank you.");
                break;
            }
        }
        sc.close();
    }
}

