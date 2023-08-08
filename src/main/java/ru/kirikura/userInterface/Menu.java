package ru.kirikura.userInterface;
import ru.kirikura.data.Data;
import ru.kirikura.service.MenuService;
import ru.kirikura.service.MonthReportService;
import java.util.Scanner;
public class Menu {
    private String[] menuOptions = new String[] {
            "1. Read report (Month or Year)",
            "2. Compare reports",
            "3. Write info about month report",
            "4. Write info about year report"
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
                    case 1 : menuService.readReport(); break;
                    case 2 : break;
                    case 3 : menuService.writeInfoAboutMonthReport(); break;
                    case 4 : break;
                    case 0 : break;
                }
            }catch (Exception e) {
                System.out.println("You wrote wrong variant.");
                scanner.next();
            }
        }
    }
}
