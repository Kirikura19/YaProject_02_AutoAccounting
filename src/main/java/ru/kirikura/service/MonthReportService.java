package ru.kirikura.service;
import ru.kirikura.data.Data;
import ru.kirikura.entity.MonthReport;
import ru.kirikura.interfaces.Printable;
import ru.kirikura.interfaces.Readable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MonthReportService implements Printable, Readable {
    private Data data;
    public MonthReportService(Data data) {
        this.data = data;
    }
    public void printReport() {
        for (Map.Entry<String, HashMap<Integer, MonthReport>> outerEntry : data.getMonthReports().entrySet()) {
            System.out.println("Statistic for " + outerEntry.getKey() + "\n");
            HashMap<Integer, MonthReport> innerMap = outerEntry.getValue();
            for (Map.Entry<Integer, MonthReport> innerEntry : innerMap.entrySet()) {
                System.out.println(innerEntry.getKey() +  " " + innerEntry.getValue().toString());
            }
        }
    }
    public void readReport(ArrayList<String> reports) {
        int i = 1;
        String curMonth = reports.get(0);
        reports.remove(0);
        HashMap<Integer, MonthReport> monthReportData = new HashMap<>();
        for(String singleReport : reports) {
            String[] toMonthReportArray = singleReport.split(",");
            MonthReport monthReport = new MonthReport(toMonthReportArray[0],
                    Boolean.valueOf(toMonthReportArray[1]), Integer.valueOf(toMonthReportArray[2]), Integer.valueOf(toMonthReportArray[3]));
            monthReportData.put(i, monthReport);
            i++;
        }
        data.getMonthReports().put(curMonth, monthReportData);
    }
}
