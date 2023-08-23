package org.example.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Selector {
    public static void select()
    {
        String jdbcUrl = "jdbc:postgresql://localhost:5432/dz18";
        String username = "postgres";
        String password = "Mettalica07";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            String sqlQuery1 = "SELECT * FROM \"public\".orders WHERE full_name = 'Chris Third'";
            String sqlQuery2 = "SELECT * FROM \"public\".order_details WHERE client_name = 'Chris Third'";
            String sqlQuery3 = "SELECT * FROM \"public\".order_details";
            String sqlQuery4 = "SELECT client_name, count(*) \n" +
                    "AS orders_count FROM \"public\".order_details GROUP BY client_name";
            String sqlQuery5 = "UPDATE \"public\".cart SET product = 'salo' WHERE product = 'super salo'";
            String sqlQuery6 = "--TRUNCATE \"public\".cart";

            System.out.println("_________________________________________________________");
            Statement statement = connection.createStatement();
            ResultSet resultSet1 = statement.executeQuery(sqlQuery1);
            while(resultSet1.next()){
                int id = resultSet1.getInt("id");
                int number = resultSet1.getInt("number");
                String name = resultSet1.getString("full_name");
                System.out.println(id+"|"+number+"|"+name);
            }
            resultSet1.close();
            statement.close();
            System.out.println("_________________________________________________________");


            Statement statement2 = connection.createStatement();
            ResultSet resultSet2 = statement2.executeQuery(sqlQuery2);
            while(resultSet2.next()){
                int id = resultSet2.getInt("id");
                int orderNum = resultSet2.getInt("order_num");
                int clientId = resultSet2.getInt("client_id");
                String clienttName = resultSet2.getString("client_name");
                String dateTime = resultSet2.getString("date_time");
                System.out.println(id+"|"+orderNum+"|"+clientId+"|"+clienttName+"|"+dateTime);
            }
            resultSet2.close();
            statement2.close();
            System.out.println("_________________________________________________________");


            Statement statement3 = connection.createStatement();
            ResultSet resultSet3 = statement3.executeQuery(sqlQuery3);
            while(resultSet3.next()){
                int id = resultSet3.getInt("id");
                int orderNum = resultSet3.getInt("order_num");
                int clientId = resultSet3.getInt("client_id");
                String clienttName = resultSet3.getString("client_name");
                String dateTime = resultSet3.getString("date_time");
                System.out.println(id+"|"+orderNum+"|"+clientId+"|"+clienttName+"|"+dateTime);
            }
            resultSet3.close();
            statement3.close();
            System.out.println("_________________________________________________________");


            Statement statement4 = connection.createStatement();
            ResultSet resultSet4 = statement4.executeQuery(sqlQuery4);
            while(resultSet4.next()){
                String name = resultSet4.getString("client_name");
                int count = resultSet4.getInt("orders_count");
                System.out.println(name+"|"+count);
            }
            resultSet4.close();
            statement4.close();
            System.out.println("_________________________________________________________");

            Statement statement5 = connection.createStatement();
            statement5.executeUpdate(sqlQuery5);
            System.out.println("Record changed");
            statement5.close();
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
