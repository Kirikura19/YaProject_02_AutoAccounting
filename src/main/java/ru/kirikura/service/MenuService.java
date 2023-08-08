package ru.kirikura.service;

import ru.kirikura.data.Data;
import ru.kirikura.entity.MonthReport;
import ru.kirikura.entity.YearReport;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MenuService {
    private Data data = new Data();
    private MonthReportService monthReportService = new MonthReportService(data);
    private YearReportService yearReportService = new YearReportService(data);
    public Path readPath() {
        // src/main/resources/m202301.csv
        Scanner scanner = new Scanner(System.in);
        Path pathToCheck;
        while (true) {
            System.out.println("Enter path to CSV file: ");
            pathToCheck = Paths.get(scanner.nextLine());
            if (!pathToCheck.getFileName().toString().matches("^[my]\\.(\\d{4}|\\d{6})\\.csv$")) {
                System.out.println("Wrong file name");
            } else if (!Files.exists(pathToCheck)) {
                System.out.println("File not exists");
            } else {
                break;
            }
        }
        System.out.println("File is uploaded.");
        return pathToCheck;
    }
    public void readReport() {
        Path path = readPath();
        ArrayList<String> tempLines = new ArrayList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path.toFile()))) {
            String tempLine = null;
            while((tempLine = bufferedReader.readLine()) != null) {
                tempLines.add(tempLine);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        switch(path.toFile().getName().split("")[0]) {
            case "m":
                tempLines.set(0, path.toFile().getName().split("")[6] + path.toFile().getName().split("")[7]);
                monthReportService.readReport(tempLines);
                break;
            case "y":
                yearReportService.readReport(tempLines);
                break;
        }
    }
    public void compareReports() {
        long money = 0;
        for (Map.Entry<String, HashMap<Integer, MonthReport>> outerEntry : data.getMonthReports().entrySet()) {
            System.out.println("Money for " + outerEntry.getKey() + "\n");
            HashMap<Integer, MonthReport> innerMap = outerEntry.getValue();
            int i = 0;
            for (Map.Entry<Integer, MonthReport> innerEntry : innerMap.entrySet()) {
                int k = 0;
                if(innerEntry.getValue().isExpensive())
                    money -= innerEntry.getValue().getSumOfOne() * innerEntry.getValue().getQuantity();
                else
                    money += innerEntry.getValue().getSumOfOne() * innerEntry.getValue().getQuantity();
                i++;
                if(i > 14) {
                    YearReport yearReport = data.getYearReportData().get(Integer.parseInt(outerEntry.getKey()) - 1 + k);
                    if( money == yearReport.getAmount() && ((money >= 0 && !yearReport.isExpensive()) || (money < 0 && yearReport.isExpensive()))) {
                        System.out.println("The half of the " + outerEntry.getKey() + " month is correct");
                        System.out.println(money);
                    }
                    else {
                        System.out.println("The half of the " + outerEntry.getKey() + " month is incorrect");
                        System.out.println(money);
                    }
                    money = 0;
                    k += 1;
                    i = 0;
                }
            }
        }
    }
    public void writeInfoAboutMonthReport() {
        if(data.getMonthReports().isEmpty())
            System.out.println("Month reports not uploaded yet.");
        else
            monthReportService.printReport();
    }
    public void writeInfoAboutYearReport() {
        if(data.getYearReportData().isEmpty())
            System.out.println("Year reports not uploaded yet.");
        else
            yearReportService.printReport();
    }
}
