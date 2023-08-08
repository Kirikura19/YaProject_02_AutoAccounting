package ru.kirikura.userInterface;
import ru.kirikura.service.MenuService;
import java.util.Scanner;
public class Menu {
    private final String[] menuOptions = new String[] {
            "1. Read report (Month or Year)",
            "2. Write info about month report",
            "3. Write info about year report",
            "4. Compare reports"
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
                    case 2 : menuService.writeInfoAboutMonthReport();
                    case 3 : menuService.writeInfoAboutYearReport(); break;
                    case 4 : menuService.compareReports();
                    case 0 : System.exit(0); break;
                }
            }catch (Exception e) {
                System.out.println("You wrote wrong variant.");
                scanner.next();
            }
        }
    }
}
