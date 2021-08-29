package lt.codeacademy.service;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LoginService extends RegisterService {
    private RegisterService rs = new RegisterService();
    private final Map<String, String> users = new HashMap<>();

    public void menu() {
        Scanner sc = new Scanner(System.in);

        boolean isLoading = true;
        while (isLoading) {

            System.out.println("------------------------");
            System.out.println("| [1] teacher login    |");
            System.out.println("| [2] teacher register |");
            System.out.println("| [3] student login    |");
            System.out.println("| [4] student register |");
            System.out.println("| [0] exit             |");
            System.out.println("------------------------");

            String choice = sc.nextLine();

            switch (choice) {
                case ("1") -> teacherLogin(sc);
                case ("2") -> teacherRegistration(sc);
                case ("3") -> studentLogin(sc);
                case ("4") -> studentRegistration(sc);
                case ("0") -> isLoading = false;
                default -> System.out.println("Please select menu item:");

            }
        }
    }


    private void teacherLogin(Scanner sc) {
        System.out.println("*** Teacher Login ***");
        System.out.println("Enter username:");
        String username = sc.nextLine();
        System.out.println("Enter password:");
        String password = sc.nextLine();

        String encodedPassword = teachersList.get(username);
        if (encodedPassword != null && encodedPassword.equals(DigestUtils.sha256Hex(password))) {
            System.out.println("Login successful");
        } else {
            System.out.println("Login error. Please check your credentials");
        }
    }

    private void studentLogin(Scanner sc) {
        System.out.println("*** Student Login ***");
        System.out.println("Enter student id:");
        String id = sc.nextLine();
        System.out.println("Enter password:");
        String password = sc.nextLine();

        String encodedPassword = studentsList.get(id);
        if (encodedPassword != null && encodedPassword.equals(DigestUtils.sha256Hex(password))) {
            System.out.println("Login successful");
        } else {
            System.out.println("Login error. Please check your credentials");
        }
    }



}
