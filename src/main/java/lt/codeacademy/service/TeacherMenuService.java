package lt.codeacademy.service;

import lt.codeacademy.service.ExamService;
import lt.codeacademy.service.MenuService;

import java.util.Scanner;

public class TeacherMenuService {
    ExamService es = new ExamService();

    public void teacherMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please select menu item:");
        boolean isLoading = true;
        while (isLoading) {

            System.out.println("------------------------");
            System.out.println("| [1] Add New Exam     |");
            System.out.println("| [2] Edit Exam        |");
            System.out.println("| [3] See All Results  |");
            System.out.println("| [0] Exit             |");
            System.out.println("------------------------");

            String choice = sc.nextLine();

            switch (choice) {
                case ("1") -> es.addExam();
                case ("2") -> es.editExam();
                case ("3") -> es.examAllResults();
                case ("0") -> isLoading = false;
                default -> System.out.println("Please select menu item:");
            }
        }
    }
}
