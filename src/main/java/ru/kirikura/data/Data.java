package ru.kirikura.data;

import ru.kirikura.entity.MonthReport;
import ru.kirikura.entity.YearReport;

import java.util.HashMap;
import java.util.List;

public class Data {

    private HashMap<String, HashMap<Integer, MonthReport>> monthReports = new HashMap<>();
    private YearReport yearReportData;
    public HashMap<String, HashMap<Integer, MonthReport>> getMonthReports() {
        return monthReports;
    }
}
