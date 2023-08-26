package org.example.shopEntity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
@Getter
@Setter
public class CustomerDetails {
    int id;
    int clientID;
    String city, email, telNumber;

    public CustomerDetails(String city, String email, String telNumber) {
        this.city = city;
        this.email = email;
        this.telNumber = telNumber;
    }
}
