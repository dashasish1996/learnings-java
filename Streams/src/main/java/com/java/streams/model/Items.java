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
public class Items {
    private String itemId;
    private int quantity;
    private String category;
    private String itemName;
    private float pricePerItem;

    public void printItemDetails() {
        System.out.println(
                "Item ID: " + itemId + ", " +
                        "Name: " + itemName + ", " +
                        "Category: " + category + ", " +
                        "Quantity: " + quantity + ", " +
                        "Price: $" + pricePerItem
        );
    }

    public static void printItemsList(List<Items> itemsList) {
        for (Items item : itemsList) {
            item.printItemDetails();
        }
    }
}
