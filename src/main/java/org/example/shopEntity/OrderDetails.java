package org.example.shopEntity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
@Getter
@Setter
@ToString
public class OrderDetails {
    int id;
    int clientID, orderNum;
    String orderDateTime;

    public OrderDetails(int clientID, int orderNum) {

        this.clientID = clientID;
        this.orderNum = orderNum;

    }
}
