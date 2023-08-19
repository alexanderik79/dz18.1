package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class TablesCreator {
    public void createTables() {
        String jdbcUrl = "jdbc:postgresql://localhost:5432/dz18";
        String username = "postgres";
        String password = "Mettalica07";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            String createCustomerQuery = "CREATE TABLE IF NOT EXISTS customer (" +
                    "id SERIAL PRIMARY KEY," +
                    "full_name VARCHAR(255) NOT NULL)";

            String createCustomerDetailsQuery = "CREATE TABLE IF NOT EXISTS customer_details (" +
                    "id SERIAL PRIMARY KEY," +
                    "client_id int NOT NULL," +
                    "email VARCHAR(255) NOT NULL," +
                    "tel_number VARCHAR(255) NOT NULL," +
                    "city VARCHAR(255)," +
                    "FOREIGN KEY (client_id) REFERENCES customer (id))";

            String createOrderQuery = "CREATE TABLE IF NOT EXISTS orders (" +
                    "id SERIAL PRIMARY KEY," +
                    "number int UNIQUE NOT NULL)";

            String createOrderDetailsQuery = "CREATE TABLE IF NOT EXISTS order_details (" +
                    "id SERIAL PRIMARY KEY," +
                    "order_num int NOT NULL," +
                    "client_id int NOT NULL," +
                    "client_name VARCHAR(255) NOT NULL," +
                    "date_time TIMESTAMP NOT NULL," +
                    "FOREIGN KEY (order_num) REFERENCES orders (number))";

            String createCartQuery = "CREATE TABLE IF NOT EXISTS cart (" +
                    "id SERIAL PRIMARY KEY," +
                    "order_num int NOT NULL," +
                    "product VARCHAR(255) NOT NULL," +
                    "price NUMERIC(10, 2) NOT NULL," +
                    "quantity int NOT NULL," +
                    "FOREIGN KEY (order_num) REFERENCES orders (number))";


            Statement statement = connection.createStatement();
            statement.executeUpdate(createCustomerQuery);
            statement.executeUpdate(createCustomerDetailsQuery);
            statement.executeUpdate(createOrderQuery);
            statement.executeUpdate(createOrderDetailsQuery);
            statement.executeUpdate(createCartQuery);

            statement.close();
            connection.close();

            System.out.println("Tables created");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

