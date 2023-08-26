package org.example.service;

import org.example.shopEntity.*;

import javax.persistence.criteria.Order;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.example.service.Properties.*;

public class TablesFiller {
    static List<Customer> customerList = new ArrayList<>();
    static List<CustomerDetails> customerDetailsList = new ArrayList<>();
    static List<Orders> ordersList = new ArrayList<>();
    static List<OrderDetails> orderDetailsList = new ArrayList<>();
    static List<Cart> cartList = new ArrayList<>();

    public static void fillTableCustomer() {
        customerList.add(new Customer("Alex First"));
        customerList.add(new Customer("Bill Second"));
        customerList.add(new Customer("Chris Third"));
        customerList.add(new Customer("Derik Fourth"));
        customerList.add(new Customer("Etan Fifth"));

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            String createCustomerQuery = "INSERT INTO customer " +
                    "(full_name) VALUES (?);";
            PreparedStatement preparedStatement = connection.prepareStatement(createCustomerQuery);
            connection.setAutoCommit(false);
            for (Iterator<Customer> iterator = customerList.iterator(); iterator.hasNext(); ) {
                Customer customer = (Customer) iterator.next();
                //              preparedStatement.setInt(1, customer.getId());
                preparedStatement.setString(1, customer.getName());
                preparedStatement.addBatch();
                preparedStatement.executeUpdate();
            }

            connection.commit();
            connection.setAutoCommit(true);
            connection.close();

            System.out.println("Table customer filled");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void fillTableCustomerDetails() {
        customerDetailsList.add(new CustomerDetails("Antwerp", "a@a.com", "+11111"));
        customerDetailsList.add(new CustomerDetails("Bombey", "b@b.com", "+22222"));
        customerDetailsList.add(new CustomerDetails("Cairo", "c@c.com", "+33333"));
        customerDetailsList.add(new CustomerDetails("Dunkirk", "d@d.comh", "+44444"));
        customerDetailsList.add(new CustomerDetails("Eden", "E@e.com", "+55555"));

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            String createCustomerQuery = "INSERT INTO customer_details " +
                    "(city, email, tel_num) VALUES (?, ?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(createCustomerQuery);
            connection.setAutoCommit(false);
            for (Iterator<CustomerDetails> iterator = customerDetailsList.iterator(); iterator.hasNext(); ) {
                CustomerDetails customerDetails = (CustomerDetails) iterator.next();
                preparedStatement.setString(1, customerDetails.getCity());
                preparedStatement.setString(2, customerDetails.getEmail());
                preparedStatement.setString(3, customerDetails.getTelNumber());
                preparedStatement.addBatch();
                preparedStatement.executeUpdate();
            }

            connection.commit();
            connection.setAutoCommit(true);
            connection.close();

            System.out.println("Table customer filled");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void fillTableOrders() {
        ordersList.add(new Orders(1, "a1", 1));
        ordersList.add(new Orders(2, "a2", 2));
        ordersList.add(new Orders(3, "a3", 2));
        ordersList.add(new Orders(4, "a4", 3));
        ordersList.add(new Orders(5, "a5", 3));
        ordersList.add(new Orders(6, "a6", 3));
        ordersList.add(new Orders(7, "a7", 4));
        ordersList.add(new Orders(8, "a8", 4));
        ordersList.add(new Orders(9, "a9", 4));
        ordersList.add(new Orders(10, "a10", 4));
        ordersList.add(new Orders(11, "a11", 5));
        ordersList.add(new Orders(12, "a12", 5));
        ordersList.add(new Orders(13, "a13", 5));
        ordersList.add(new Orders(14, "a14", 5));
        ordersList.add(new Orders(15, "a15", 5));

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            String createOderQuery = "INSERT INTO orders " +
                    "(id, number, client_id) VALUES (?, ?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(createOderQuery);
            connection.setAutoCommit(false);
            for (Iterator<Orders> iterator = ordersList.iterator(); iterator.hasNext(); ) {
                Orders orders = (Orders) iterator.next();
                preparedStatement.setInt(1, orders.getId());
                preparedStatement.setString(2, orders.getNumber());
                preparedStatement.setInt(3, orders.getClientId());
                preparedStatement.addBatch();
                preparedStatement.executeUpdate();
            }

            connection.commit();
            connection.setAutoCommit(true);
            connection.close();

            System.out.println("Table customer filled");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void fillTableOrderDetails() {
        orderDetailsList.add(new OrderDetails(1, 1));
        orderDetailsList.add(new OrderDetails(2, 2));
        orderDetailsList.add(new OrderDetails(2, 3));
        orderDetailsList.add(new OrderDetails(3, 4));
        orderDetailsList.add(new OrderDetails(3, 5));
        orderDetailsList.add(new OrderDetails(3, 6));
        orderDetailsList.add(new OrderDetails(4, 7));
        orderDetailsList.add(new OrderDetails(4, 8));
        orderDetailsList.add(new OrderDetails(4, 9));
        orderDetailsList.add(new OrderDetails(4, 10));
        orderDetailsList.add(new OrderDetails(5, 11));
        orderDetailsList.add(new OrderDetails(5, 12));
        orderDetailsList.add(new OrderDetails(5, 13));
        orderDetailsList.add(new OrderDetails(5, 14));
        orderDetailsList.add(new OrderDetails(5, 15));

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            String createOderDetailsQuery = "INSERT INTO order_details " +
                    "(client_id, date_time) VALUES (?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(createOderDetailsQuery);
            connection.setAutoCommit(false);
            for (Iterator<OrderDetails> iterator = orderDetailsList.iterator(); iterator.hasNext(); ) {
                OrderDetails orderDetails = (OrderDetails) iterator.next();
                preparedStatement.setInt(1, orderDetails.getClientID());
                preparedStatement.setTimestamp(2, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
                preparedStatement.addBatch();
                preparedStatement.executeUpdate();
            }

            connection.commit();
            connection.setAutoCommit(true);
            connection.close();

            System.out.println("Table order_details filled");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void fillTableCart() {
        cartList.add(new Cart(1, 2,100, "sugar"));
        cartList.add(new Cart(2, 3,22, "eggs"));
        cartList.add(new Cart(3, 5,200, "beer"));
        cartList.add(new Cart(4, 1,300, "vodka"));
        cartList.add(new Cart(5, 8,33, "salt"));
        cartList.add(new Cart(6, 3,133, "water"));
        cartList.add(new Cart(7, 1,214, "wine"));
        cartList.add(new Cart(8, 3,114, "pc"));
        cartList.add(new Cart(9, 7,14, "carpet"));
        cartList.add(new Cart(10, 5,200, "beer"));
        cartList.add(new Cart(12, 1,300, "vodka"));
        cartList.add(new Cart(13, 8,33, "salt"));
        cartList.add(new Cart(14, 3,133, "water"));
        cartList.add(new Cart(15, 1,214, "wine"));
        cartList.add(new Cart(1, 3,114, "pc"));
        cartList.add(new Cart(2, 7,14, "carpet"));
        cartList.add(new Cart(10,5,334, "socks"));
        cartList.add(new Cart(11,1,25, "nails"));
        cartList.add(new Cart(12,2,55, "bolts"));
        cartList.add(new Cart(13,9,59, "gas"));
        cartList.add(new Cart(14,1,57, "wood"));
        cartList.add(new Cart(15,3,333, "shit"));

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            String createOderQuery = "INSERT INTO cart " +
                    "(order_num, quantity, price, product) VALUES (?, ?, ?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(createOderQuery);
            connection.setAutoCommit(false);
            for (Iterator<Cart> iterator = cartList.iterator(); iterator.hasNext(); ) {
                Cart cart = (Cart) iterator.next();
                preparedStatement.setInt(1, cart.getOrderNum());
                preparedStatement.setInt(2, cart.getQuantity());
                preparedStatement.setDouble(3, cart.getPrice());
                preparedStatement.setString(4, cart.getProduct());
                preparedStatement.addBatch();
                preparedStatement.executeUpdate();
            }

            connection.commit();
            connection.setAutoCommit(true);
            connection.close();

            System.out.println("Table cart filled");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

//                String createCartQuery = "INSERT INTO cart " +
//                    "(id, order_num, price, product, quantity) VALUES " +
//                    "(default, 1, 100.05, 'vodka', 1)," +
//                    "(default, 2, 200.20, 'martini', 1)," +
//                    "(default, 2, 333.33, 'beer', 8)," +
//                    "(default, 3, 444.44, 'water', 40)," +
//                    "(default, 3, 400.40, 'juice', 5)," +
//                    "(default, 3, 500.00, 'wine', 1)," +
//                    "(default, 4, 125.90, 'kovbasa', 1)," +
//                    "(default, 4, 210.00, 'jin', 1)," +
//                    "(default, 4, 600.00, 'salo', 3)," +
//                    "(default, 4, 1000.00, 'fish', 5)";
//}


//            String createCustomerQuery = "INSERT INTO customer " +
//                    "(id, full_name) VALUES " +
//                    "(default, 'Alex First')," +
//                    "(default, 'Bill Second')," +
//                    "(default, 'Chris Third')," +
//                    "(default, 'Derik Fourth')," +
//                    "(default, 'Etan Fifth')";


//            String createCustomerDetailsQuery = "INSERT INTO customer_details " +
//                    "(id, city, client_id, email, tel_number) VALUES " +
//                    "(default, 'Antwerp', default, 'a@a.com', '+111111')," +
//                    "(default, 'Bombey', default, 'b@b.com', '+222222')," +
//                    "(default, 'Cairo', default, 'c@c.com', '+333333')," +
//                    "(default, 'Dunkirk', default, 'd@d.com', '+444444')," +
//                    "(default, 'Eden', default, 'e@e.com', '+555555')";
//
//            String createOrderQuery = "INSERT INTO orders " +
//                    "(id, number, client_id) VALUES " +
//                    "(default, default, default)," +
//                    "(default, default, default)," +
//                    "(default, default, default)," +
//                    "(default, default, default)," +
//                    "(default, default, default)";
//
//
//            String createOrderDetailsQuery = "INSERT INTO order_details " +
//                    "(id, client_id, client_name, date_time, order_num) VALUES " +
//                    "(default, 1, 'Alex First', NOW(), 1)," +
//                    "(default, 2, 'Bill Second', NOW(), 2)," +
//                    "(default, 2, 'Bill Second', NOW(), 2)," +
//                    "(default, 3,'Chris Third', NOW(), 3)," +
//                    "(default, 3,'Chris Third', NOW(), 3)," +
//                    "(default, 3,'Chris Third', NOW(), 3)," +
//                    "(default, 4,'Derik Fourth', NOW(), 4)," +
//                    "(default, 4,'Derik Fourth', NOW(), 4)," +
//                    "(default, 4,'Derik Fourth', NOW(), 4)," +
//                    "(default, 4,'Derik Fourth', NOW(), 4)";
//
//            String createCartQuery = "INSERT INTO cart " +
//                    "(id, order_num, price, product, quantity) VALUES " +
//                    "(default, 1, 100.05, 'vodka', 1)," +
//                    "(default, 2, 200.20, 'martini', 1)," +
//                    "(default, 2, 333.33, 'beer', 8)," +
//                    "(default, 3, 444.44, 'water', 40)," +
//                    "(default, 3, 400.40, 'juice', 5)," +
//                    "(default, 3, 500.00, 'wine', 1)," +
//                    "(default, 4, 125.90, 'kovbasa', 1)," +
//                    "(default, 4, 210.00, 'jin', 1)," +
//                    "(default, 4, 600.00, 'salo', 3)," +
//                    "(default, 4, 1000.00, 'fish', 5)";
//
//
//            Statement statement = connection.createStatement();
//            statement.executeUpdate(createCustomerQuery);
//            statement.executeUpdate(createCustomerDetailsQuery);
//            statement.executeUpdate(createOrderQuery);
//            statement.executeUpdate(createOrderDetailsQuery);
//            statement.executeUpdate(createCartQuery);
//
//            statement.close();