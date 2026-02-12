package com.ecommerce;

import java.sql.*;

public class App {

    static final String JDBC_URL = "jdbc:mysql://localhost:3306/bankapp";
    static final String DB_USER = "root";
    static final String DB_PASSWORD = "root";

    public static void main(String[] args) {

        try (
                // Step 1: Establish connection
                Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);

                // Step 2: Create statement
                Statement statement = connection.createStatement()
        ) {

            System.out.println("Connected to the database successfully!");

            // Step 3: Execute SQL query
            String sqlQuery = "SELECT * FROM account";

            ResultSet resultSet = statement.executeQuery(sqlQuery);

            // Step 4: Process the result
            while (resultSet.next()) {

                // Change column names according to your table
                int id = resultSet.getInt("account_id");
                String name = resultSet.getString("customer_name");
                int balance = resultSet.getInt("balance");

                System.out.println(id + " | " + name + " | " + balance);
            }

            resultSet.close();

        } catch (SQLException e) {
            System.err.println("SQL error: "+e.getMessage());
            e.printStackTrace();
        }
    }
}





