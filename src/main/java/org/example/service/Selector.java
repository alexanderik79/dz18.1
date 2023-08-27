package org.example.service;

import org.example.shopEntity.Customer;
import org.example.shopEntity.OrderDetails;
import org.example.shopEntity.Orders;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import static org.example.service.Properties.*;

public class Selector {
    public static void select()
    {
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            String sqlQuery1 = "SELECT * FROM \"public\".orders WHERE client_id = 2";
            String sqlQuery2 = "SELECT * FROM \"public\".order_details WHERE client_id = 3";
            String sqlQuery3 = "SELECT * FROM \"public\".orders";
            String sqlQuery4 = "SELECT client_id, count(*) \n" +
                    "AS orders_count FROM \"public\".order_details GROUP BY client_id";
            String sqlQuery5 = "UPDATE \"public\".cart SET product = 'super salo' WHERE product = 'pc'";
            String sqlQuery7 = "select full_name, email, tel_num, city, number, date_time, product, quantity, price" +
                    " from \"public\".customer c, \"public\".customer_details cd, \"public\".orders o, \n" +
                    "\"public\".order_details od, \"public\".cart ca\n" +
                    "where c.id = cd.client_id and c.id = o.client_id and o.id = od.order_num and od.id = ca.order_num;";
            String sqlQuery6 = "TRUNCATE \"public\".cart";
            System.out.println("_________________________________________________________");

            System.out.println("всі замовлення для 1 кастомера:");
            Statement statement = connection.createStatement();
            ResultSet resultSet1 = statement.executeQuery(sqlQuery1);
            while(resultSet1.next()){
                int id = resultSet1.getInt("id");
                String number = resultSet1.getString("number");
                int clientId = resultSet1.getInt("client_id");
                Orders orders = new Orders(id, number, clientId);
               // System.out.println(orders.getId()+"|"+orders.getNumber()+"|"+orders.getClientId());
                System.out.println(orders.toString());
            }
            resultSet1.close();
            statement.close();
            System.out.println("_________________________________________________________");

            System.out.println("всі замовлення із деталями для одного кастомера:");
            Statement statement2 = connection.createStatement();
            ResultSet resultSet2 = statement2.executeQuery(sqlQuery2);
            while(resultSet2.next()){
                int id = resultSet2.getInt("id");
                int orderNum = resultSet2.getInt("order_num");
                int clientId = resultSet2.getInt("client_id");
                String dateTime = resultSet2.getString("date_time");
                OrderDetails orderDetails = new OrderDetails(clientId, orderNum);
                orderDetails.setClientID(clientId);
                orderDetails.setOrderDateTime(dateTime);
                System.out.println(orderDetails.toString());
            }
            resultSet2.close();
            statement2.close();
            System.out.println("_________________________________________________________");

            System.out.println("всі замовлення для всіх кастомерів:");
            Statement statement3 = connection.createStatement();
            ResultSet resultSet3 = statement3.executeQuery(sqlQuery3);
            while(resultSet3.next()){
                int id = resultSet3.getInt("id");
                String number = resultSet3.getString("number");
                int clientId = resultSet3.getInt("client_id");
                //System.out.println(id+"|"+orderNum+"|"+clientId+"|"+clienttName+"|"+dateTime);
                Orders orders = new Orders(id, number, clientId);
                System.out.println(orders.toString());
            }
            resultSet3.close();
            statement3.close();
            System.out.println("_________________________________________________________");

            System.out.println("кількість замовлень у кожного кастомера:");
            Statement statement4 = connection.createStatement();
            ResultSet resultSet4 = statement4.executeQuery(sqlQuery4);
            while(resultSet4.next()){
                int client_id = resultSet4.getInt("client_id");
                int count = resultSet4.getInt("orders_count");
                System.out.println(client_id+"|"+count);
            }
            resultSet4.close();
            statement4.close();
            System.out.println("_________________________________________________________");


            Statement statement5 = connection.createStatement();
            statement5.executeUpdate(sqlQuery5);
            System.out.println("Record changed");
            statement5.close();
            System.out.println("_________________________________________________________");


            System.out.println("просто всі дані:");
            Statement statement7 = connection.createStatement();
            ResultSet resultSet7 = statement7.executeQuery(sqlQuery7);
            while(resultSet7.next()){
                String full_name = resultSet7.getString("full_name");
                String email = resultSet7.getString("email");
                String tel_num = resultSet7.getString("tel_num");
                String city = resultSet7.getString("city");
                String number = resultSet7.getString("number");
                String date_time = resultSet7.getString("date_time");
                String product = resultSet7.getString("product");
                int quantity = resultSet7.getInt("quantity");
                double price = resultSet7.getDouble("price");
                System.out.println(full_name+"\t|"+email+" |"+tel_num+" |"+city+"  \t| "+number+" \t|"+date_time
                        +"\t|"+product+"\t|"+quantity+"\t|"+price);
            }
            resultSet7.close();
            statement7.close();
            System.out.println("_________________________________________________________");


            Statement statement6 = connection.createStatement();
            statement6.executeUpdate(sqlQuery6);
            System.out.println("Cart erased");
            statement6.close();
            System.out.println("_________________________________________________________");

            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
