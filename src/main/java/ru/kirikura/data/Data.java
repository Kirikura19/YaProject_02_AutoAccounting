package ru.kirikura.data;

import ru.kirikura.entity.MonthReport;
import ru.kirikura.entity.YearReport;
import java.util.ArrayList;
import java.util.HashMap;

public class Data {

    private HashMap<String, HashMap<Integer, MonthReport>> monthReports = new HashMap<>();
    private ArrayList<YearReport> yearReportData = new ArrayList<>();

    public ArrayList<YearReport> getYearReportData() {
        return yearReportData;
    }

    public void setYearReportData(ArrayList<YearReport>yearReportData) {
        this.yearReportData = yearReportData;
    }

    public HashMap<String, HashMap<Integer, MonthReport>> getMonthReports() {
        return monthReports;
    }
}
