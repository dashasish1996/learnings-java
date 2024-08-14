package com.java.streams.filters;

import com.java.streams.model.Items;
import com.java.streams.utils.GenerateOrderItemData;
import com.java.streams.utils.GenerateStrIntLists;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.function.Predicate;

@Slf4j
public class FilterBasics {
    //Question 1: Filtering Even Numbers
    private static void filterEvenNumbers(List<Integer> inputList) {
        log.info("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  Filtering Even Numbers  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        log.info("Input List: {}", inputList);
        var op = inputList.stream().filter(i -> i % 2 == 0).toList();
        log.info("Output: {}", op);
    }

    //Question 2: Filtering by String Length
    private static void filterByStringLength(List<String> inputList) {
        log.info("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  Filtering by String Length  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        log.info("Input List: {}", inputList);
        var op = inputList.stream().filter(i -> i.length() > 5).toList();
        log.info("Output: {}", op);
    }

    //Question 11: Filtering Items Using a Predicate
    /*
    Predicates are a type of Functional Interface that accepts a single input and returns a boolean value as output
    */

    //Defining a predicate as per need
    public static Predicate<Items> isCategoryAndPriceAbove(String category, float priceThreshold) {
        return item -> item.getCategory().equals(category) && item.getPricePerItem() > priceThreshold;
    }

    public static void filterItems(List<Items> items, Predicate<Items> predicate) {
        log.info("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  Filtering by Predicate  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        var result = items.stream()
                .filter(predicate)
                .toList();
        log.info("Result:");
        Items.printItemsList(result);
    }


    public static void main(String[] args) {
        filterEvenNumbers(GenerateStrIntLists.getIntegerList());
        filterByStringLength(GenerateStrIntLists.getStringList());
        filterItems(GenerateOrderItemData.createItemList(), isCategoryAndPriceAbove("Electronics", 100.0f));
    }
}
