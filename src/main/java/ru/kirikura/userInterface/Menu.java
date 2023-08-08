package ru.kirikura.userInterface;
import ru.kirikura.data.Data;
import ru.kirikura.service.MenuService;
import ru.kirikura.service.MonthReportService;
import java.util.Scanner;
public class Menu {
    private String[] menuOptions = new String[] {
            "1. Read month report",
            "2. Read year report",
            "3. Compare reports",
            "4. Write info about month report",
            "5. Write info about year report"
    };
    public void printMenu() {
        System.out.println("\n");
        for(String option : menuOptions) {
            System.out.println(option);
        }
        System.out.println("\n");
    }
    public void userChoice() {
        Scanner scanner = new Scanner(System.in);
        MenuService menuService = new MenuService();
        int option = -1;
        while(option != 0) {
            printMenu();
            try {
                System.out.print("> ");
                option = scanner.nextInt();
                switch (option) {
                    case 1 : menuService.readMonthReport(); break;
                    case 2 : break;
                    case 3 : break;
                    case 4 : menuService.writeInfoAboutMonthReport(); break;
                    case 5 : break;
                    case 0 : break;
                }
            }catch (Exception e) {
                System.out.println("You wrote wrong variant.");
                scanner.next();
            }
        }
    }
    /*
    * Console menu:
1. Read month report - InputReportService -> MonthService -> MonthReport
2. Read year report ...
3. Compare reports
4. Write info about month report -
5. Write info about year report*/
}
