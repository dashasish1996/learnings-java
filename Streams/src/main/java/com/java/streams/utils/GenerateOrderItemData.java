package com.java.streams.utils;

import com.java.streams.model.Items;
import com.java.streams.model.Orders;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class GenerateOrderItemData {
    public List<Items> createItemList() {
        List<Items> itemList = new ArrayList<>();

        itemList.add(new Items("I001", 10, "Electronics", "Laptop", 999.99f));
        itemList.add(new Items("I002", 5, "Books", "Java Programming", 49.99f));
        itemList.add(new Items("I003", 20, "Clothing", "T-Shirt", 19.99f));
        itemList.add(new Items("I004", 15, "Groceries", "Apple", 0.99f));
        itemList.add(new Items("I005", 25, "Electronics", "Headphones", 199.99f));
        itemList.add(new Items("I006", 10, "Books", "Python Cookbook", 59.99f));
        itemList.add(new Items("I007", 30, "Clothing", "Jeans", 39.99f));
        itemList.add(new Items("I008", 12, "Groceries", "Milk", 1.49f));
        itemList.add(new Items("I009", 8, "Electronics", "Smartphone", 499.99f));
        itemList.add(new Items("I010", 3, "Books", "Spring Boot in Action", 39.99f));

        return itemList;
    }


    public List<Orders> createOrderList() {
        List<Orders> orderList = new ArrayList<>();
        List<Items> items1 = createItemList().subList(0, 3);
        List<Items> items2 = createItemList().subList(3, 7);
        List<Items> items3 = createItemList().subList(7, 10);

        orderList.add(new Orders("O001", "Alice", "Downtown", items1));
        orderList.add(new Orders("O002", "Bob", "Uptown", items2));
        orderList.add(new Orders("O003", "Charlie", "Suburbs", items3));
        orderList.add(new Orders("O004", "David", "Downtown", items1));
        orderList.add(new Orders("O005", "Eve", "Uptown", items2));
        orderList.add(new Orders("O006", "Frank", "Suburbs", items3));
        orderList.add(new Orders("O007", "Grace", "Downtown", items1));
        orderList.add(new Orders("O008", "Hank", "Uptown", items2));
        orderList.add(new Orders("O009", "Ivy", "Suburbs", items3));
        orderList.add(new Orders("O010", "Jack", "Downtown", items1));

        return orderList;
    }
}
