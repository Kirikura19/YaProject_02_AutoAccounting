package ru.kirikura.service;
import ru.kirikura.data.Data;
import ru.kirikura.entity.YearReport;
import ru.kirikura.interfaces.Printable;
import ru.kirikura.interfaces.Readable;
import java.util.ArrayList;

public class YearReportService implements Printable, Readable {
    private Data data;

    public YearReportService(Data data) {
        this.data = data;
    }

    public void printReport() {
        for (YearReport yearReport: data.getYearReportData()) {
            System.out.println(yearReport.toString());
        }
    }
    public void readReport(ArrayList<String> report) {
        report.remove(0);
        ArrayList<YearReport> yearReportData = new ArrayList<>();
        for(String singleReport : report) {
            String[] toYearReportArray = singleReport.split(",");
            YearReport yearReport = new YearReport(toYearReportArray[0], Integer.valueOf(toYearReportArray[1]),
                    Boolean.valueOf(toYearReportArray[2]));
            yearReportData.add(yearReport);
        }
        data.setYearReportData(yearReportData);
    }
}
