package org.example.shopEntity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Customer {
    private int id;
    private String name;

    public Customer(String name) {
        this.name = name;
    }
}
