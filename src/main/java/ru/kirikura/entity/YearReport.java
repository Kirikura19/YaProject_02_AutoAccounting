package ru.kirikura.entity;

import java.util.ArrayList;

public class YearReport {
    String month;
    int amount;
    boolean isExpensive;

    public YearReport(String month, int amount, boolean isExpensive) {
        this.month = month;
        this.amount = amount;
        this.isExpensive = isExpensive;
    }
}
