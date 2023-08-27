package org.example;

import org.example.service.Selector;
import org.example.service.TablesCreator;
import org.example.service.TablesFiller;


public class Main {
    public static void main(String[] args) {
        TablesCreator.createTables();
        TablesFiller.fillTableCustomer();
        TablesFiller.fillTableCustomerDetails();
        TablesFiller.fillTableOrders();
        TablesFiller.fillTableOrderDetails();
        TablesFiller.fillTableCart();
        Selector.select();
    }
}