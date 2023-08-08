package ru.kirikura.data;

import ru.kirikura.entity.MonthReport;
import ru.kirikura.entity.YearReport;

import java.util.HashMap;
import java.util.List;

public class Data {

    //private HashMap<Integer, MonthReport> monthReportData;
    private HashMap<String, HashMap<Integer, MonthReport>> monthReports = new HashMap<>();
    private YearReport yearReportData;
    public HashMap<String, HashMap<Integer, MonthReport>> getMonthReports() {
        return monthReports;
    }
    //HashMap<String, MonthReport>
    //YearReport
    //going to add two data structure to save year and months reports
}
