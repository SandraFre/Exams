package lt.codeacademy.service;

import java.util.Scanner;

public class MenuService {
    private LoginService ls = new LoginService();
    private RegisterService rs = new RegisterService();

    public void menu() {
        Scanner sc = new Scanner(System.in);

        boolean isLoading = true;
        while (isLoading) {

            System.out.println("------------------------");
            System.out.println("| [1] Login            |");
            System.out.println("| [2] Register         |");
            System.out.println("| [0] Exit             |");
            System.out.println("------------------------");

            String choice = sc.nextLine();

            switch (choice) {
                case ("1") -> loginMenu(sc);
                case ("2") -> registerMenu(sc);
                case ("0") -> isLoading = false;
                default -> System.out.println("Please select menu item:");
            }
        }
    }

    private void loginMenu(Scanner sc) {
        while (true) {
            System.out.println("------------------------");
            System.out.println("| [1] Teacher login    |");
            System.out.println("| [2] Student login    |");
            System.out.println("| [0] Main menu        |");
            System.out.println("------------------------");

            String choice = sc.nextLine();

            switch (choice) {
                case ("1") -> ls.teacherLogin(sc);
                case ("2") -> ls.studentLogin(sc);
                case ("0") -> menu();
                default -> System.out.println("Please select menu item:");

            }
        }
    }

    private void registerMenu(Scanner sc) {
        while (true) {
            System.out.println("------------------------");
            System.out.println("| [1] Teacher register |");
            System.out.println("| [2] Student register |");
            System.out.println("| [0] Main menu        |");
            System.out.println("------------------------");

            String choice = sc.nextLine();

            switch (choice) {
                case ("1") -> rs.teacherRegistration(sc);
                case ("2") -> rs.studentRegistration(sc);
                case ("0") -> menu();
                default -> System.out.println("Please select menu item:");

            }
        }
    }
}
