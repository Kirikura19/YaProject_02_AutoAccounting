package ru.kirikura.entity;

import java.util.ArrayList;

public class MonthReport {
    String itemName;
    boolean isExpensive;
    int quantity;
    int sumOfOne;

    public MonthReport(String itemName, boolean isExpensive, int quantity, int sumOfOne) {
        this.itemName = itemName;
        this.isExpensive = isExpensive;
        this.quantity = quantity;
        this.sumOfOne = sumOfOne;
    }
}
