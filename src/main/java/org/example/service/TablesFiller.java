package org.example.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TablesFiller {

    public static void fillTables(){
        String jdbcUrl = "jdbc:postgresql://localhost:5432/dz18";
        String username = "postgres";
        String password = "Mettalica07";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            String createCustomerQuery = "INSERT INTO customer " +
                    "(id, full_name) VALUES " +
                    "(default, 'Alex First')," +
                    "(default, 'Bill Second')," +
                    "(default, 'Chris Third')," +
                    "(default, 'Derik Fourth')," +
                    "(default, 'Etan Fifth')";

            String createCustomerDetailsQuery = "INSERT INTO customer_details " +
                    "(id, city, client_id, email, tel_number) VALUES " +
                    "(default, 'Antwerp', default, 'a@a.com', '+111111')," +
                    "(default, 'Bombey', default, 'b@b.com', '+222222')," +
                    "(default, 'Cairo', default, 'c@c.com', '+333333')," +
                    "(default, 'Dunkirk', default, 'd@d.com', '+444444')," +
                    "(default, 'Eden', default, 'e@e.com', '+555555')";

            String createOrderQuery = "INSERT INTO orders " +
                    "(id, number, full_name) VALUES " +
                    "(default, default, 'Alex First')," +
                    "(default, default, 'Bill Second')," +
                    "(default, default, 'Chris Third')," +
                    "(default, default, 'Derik Fourth')," +
                    "(default, default, 'Etan Fifth')";


            String createOrderDetailsQuery = "INSERT INTO order_details " +
                    "(id, client_id, client_name, date_time, order_num) VALUES " +
                    "(default, 1, 'Alex First', NOW(), 1)," +
                    "(default, 2, 'Bill Second', NOW(), 2)," +
                    "(default, 2, 'Bill Second', NOW(), 2)," +
                    "(default, 3,'Chris Third', NOW(), 3)," +
                    "(default, 3,'Chris Third', NOW(), 3)," +
                    "(default, 3,'Chris Third', NOW(), 3)," +
                    "(default, 4,'Derik Fourth', NOW(), 4)," +
                    "(default, 4,'Derik Fourth', NOW(), 4)," +
                    "(default, 4,'Derik Fourth', NOW(), 4)," +
                    "(default, 4,'Derik Fourth', NOW(), 4)";

            String createCartQuery = "INSERT INTO cart " +
                    "(id, order_num, price, product, quantity) VALUES " +
                    "(default, 1, 100.05, 'vodka', 1)," +
                    "(default, 2, 200.20, 'martini', 1)," +
                    "(default, 2, 333.33, 'beer', 8)," +
                    "(default, 3, 444.44, 'water', 40)," +
                    "(default, 3, 400.40, 'juice', 5)," +
                    "(default, 3, 500.00, 'wine', 1)," +
                    "(default, 4, 125.90, 'kovbasa', 1)," +
                    "(default, 4, 210.00, 'jin', 1)," +
                    "(default, 4, 600.00, 'salo', 3)," +
                    "(default, 4, 1000.00, 'fish', 5)";


            Statement statement = connection.createStatement();
            statement.executeUpdate(createCustomerQuery);
            statement.executeUpdate(createCustomerDetailsQuery);
            statement.executeUpdate(createOrderQuery);
            statement.executeUpdate(createOrderDetailsQuery);
            statement.executeUpdate(createCartQuery);


            statement.close();
            connection.close();

            System.out.println("Tables filled");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
