package org.example.shopEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cart {
    private int id;
    private int orderNum, quantity;
    private double price;
    private String product;

    public Cart(int orderNum, int quantity, double price, String product) {
        this.orderNum = orderNum;
        this.quantity = quantity;
        this.price = price;
        this.product = product;
    }
}
