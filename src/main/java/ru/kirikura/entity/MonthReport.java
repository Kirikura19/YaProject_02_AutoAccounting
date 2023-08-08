package ru.kirikura.entity;

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

    public String getItemName() {
        return itemName;
    }

    public boolean isExpensive() {
        return isExpensive;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getSumOfOne() {
        return sumOfOne;
    }

    @Override
    public String toString() {
        return "{" +
                "itemName='" + itemName + '\'' +
                ", isExpensive=" + isExpensive +
                ", quantity=" + quantity +
                ", sumOfOne=" + sumOfOne +
                '}';
    }
}
