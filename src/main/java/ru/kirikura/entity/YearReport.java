package ru.kirikura.entity;

public class YearReport {
    String month;
    int amount;
    boolean isExpensive;
    public YearReport(String month, int amount, boolean isExpensive) {
        this.month = month;
        this.amount = amount;
        this.isExpensive = isExpensive;
    }

    public String getMonth() {
        return month;
    }

    public int getAmount() {
        return amount;
    }

    public boolean isExpensive() {
        return isExpensive;
    }

    @Override
    public String toString() {
        return "YearReport{" +
                "month='" + month + '\'' +
                ", amount=" + amount +
                ", isExpensive=" + isExpensive +
                '}';
    }
}
