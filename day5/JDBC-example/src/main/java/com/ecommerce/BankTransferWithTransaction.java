package com.ecommerce;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class BankTransferWithTransaction {

    static final String JDBC_URL = "jdbc:mysql://localhost:3306/bankapp";
    static final String DB_USER = "root";
    static final String DB_PASSWORD = "root";

    public static void transferFunds(int fromAccountId,
                                     int toAccountId,
                                     double amount) {

        String debitSql =
                "UPDATE account SET balance = balance - ? " +
                        "WHERE account_id = ? AND balance >= ?";

        String creditSql =
                "UPDATE account SET balance = balance + ? " +
                        "WHERE account_id = ?";

        Connection connection = null;
        PreparedStatement debitStmt = null;
        PreparedStatement creditStmt = null;

        try {
            // Step 1: Establish connection
            connection = DriverManager.getConnection(
                    JDBC_URL, DB_USER, DB_PASSWORD);

            // Step 2: Disable auto-commit (Start Transaction)
            connection.setAutoCommit(false);

            // Step 3: Prepare statements
            debitStmt = connection.prepareStatement(debitSql);
            creditStmt = connection.prepareStatement(creditSql);

            // ---- Debit ----
            debitStmt.setDouble(1, amount);
            debitStmt.setInt(2, fromAccountId);
            debitStmt.setDouble(3, amount);

            int rowsDebited = debitStmt.executeUpdate();

            if (rowsDebited == 0) {
                throw new SQLException("Insufficient balance or account not found.");
            }

            // ---- Credit ----
            creditStmt.setDouble(1, amount);
            creditStmt.setInt(2, toAccountId);

            creditStmt.executeUpdate();

            // Step 4: Commit transaction
            connection.commit();

            System.out.printf("₹%.2f transferred from Account %d to Account %d%n",
                    amount, fromAccountId, toAccountId);

        } catch (SQLException e) {

            System.err.println("Transfer Error: " + e.getMessage());

            // Step 5: Rollback if error occurs
            if (connection != null) {
                try {
                    connection.rollback();
                    System.out.println("Transaction rolled back. No changes made.");
                } catch (SQLException rollbackEx) {
                    System.err.println("Rollback Error: " + rollbackEx.getMessage());
                }
            }

        } finally {

            // Step 6: Close resources
            try {
                if (debitStmt != null) debitStmt.close();
                if (creditStmt != null) creditStmt.close();

                if (connection != null) {
                    connection.setAutoCommit(true); // reset
                    connection.close();
                }

            } catch (SQLException closeEx) {
                System.err.println("Resource closing failed: " + closeEx.getMessage());
            }
        }
    }

    // Main method to test
    public static void main(String[] args) {



        Scanner scan = new Scanner(System.in);

        System.out.println("====== BANK TRANSFER SYSTEM ======");

        System.out.print("Enter From Account ID: ");
        int fromId = scan.nextInt();

        System.out.print("Enter To Account ID: ");
        int toId = scan.nextInt();

        System.out.print("Enter Amount to Transfer: ");
        double amount = scan.nextDouble();

        transferFunds(fromId, toId, amount);

        scan.close();
        // Example transfer
        transferFunds(202, 201, 5005.00);
    }
}
