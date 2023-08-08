package ru.kirikura.service;

import ru.kirikura.data.Data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuService {
    private Data data = new Data();
    private MonthReportService monthReportService = new MonthReportService(data);
    public Path readPath() {
        // src/main/resources/m202301.csv
        Scanner scanner = new Scanner(System.in);
        Path pathToCheck;

        while (true) {
            System.out.println("Enter path to CSV file: ");
            pathToCheck = Paths.get(scanner.nextLine());

            if (!pathToCheck.getFileName().toString().matches("[my]\\d{6}\\.csv")) {
                System.out.println("Wrong file name");
            } else if (!Files.exists(pathToCheck)) {
                System.out.println("File not exists");
            } else {
                break;
            }
        }
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
                tempLines.set(0, path.toFile().getName().split("")[5] + path.toFile().getName().split("")[6]);
                monthReportService.readReport(tempLines);
                break;
            case "y":
                break;

        }
    }
    public void compareReports() {}
    public void writeInfoAboutMonthReport() {
        if(data.getMonthReports().isEmpty())
            System.out.println("Month reports not uploaded yet.");
        else
            monthReportService.printReport();
    }
    public void writeInfoAboutYearReport() {}

    //1. -> path -> File.read, String[] -> MonthService
    //...
    //3. -> from Data we take MonthReport<> YearReport<> & calculate
    //4.
}
