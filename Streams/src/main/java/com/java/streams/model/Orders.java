package com.java.streams.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Orders {
    private String orderId;
    private String customerName;
    private String area;
    private List<Items> items;

    public void printOrderDetails() {
        System.out.println(
                "Order ID: " + orderId + ", " +
                        "Customer: " + customerName + ", " +
                        "Area: " + area
        );
        System.out.println("Items:");
        Items.printItemsList(items);
    }

    public static void printOrdersList(List<Orders> ordersList) {
        for (Orders order : ordersList) {
            order.printOrderDetails();
        }
    }

}
