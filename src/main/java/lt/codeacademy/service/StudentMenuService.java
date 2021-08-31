package lt.codeacademy.service;

import lt.codeacademy.service.ExamService;
import lt.codeacademy.service.MenuService;

import java.util.Scanner;

public class StudentMenuService {

    ExamService es = new ExamService();

    public void studentMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please select menu item:");
        boolean isLoading = true;
        while (isLoading) {

            System.out.println("------------------------");
            System.out.println("| [1] Start Exam       |");
            System.out.println("| [2] See Results      |");
            System.out.println("| [0] Exit             |");
            System.out.println("------------------------");

            String choice = sc.nextLine();

            switch (choice) {
                case ("1") -> es.startExam();
                case ("2") -> es.examStudentResult();
                case ("0") -> isLoading = false;
                default -> System.out.println("Please select menu item:");
            }
        }
    }
}


