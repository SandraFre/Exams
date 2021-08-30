package lt.codeacademy.service;

import java.util.Scanner;

public class StudentMenuService extends MenuService{

    ExamService es = new ExamService();

    public void menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please select menu item:");
        boolean isLoading = true;
        while (isLoading) {

            System.out.println("------------------------");
            System.out.println("| [1] Start Exam       |");
            System.out.println("| [2] See Results      |");
            System.out.println("| [0] Main menu        |");
            System.out.println("------------------------");

            String choice = sc.nextLine();

            switch (choice) {
                case ("1") -> es.startExam();
                case ("2") -> es.examResult();
                case ("0") -> menu();
                default -> System.out.println("Please select menu item:");
            }
        }
    }
}


