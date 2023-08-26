package org.example.shopEntity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
public class Orders {
    private int id;
    private String number;
    private int clientId;


    public Orders(int id, String number, int clientId) {
        this.id = id;
        this.number = number;
        this.clientId = clientId;
    }
}
