package lt.codeacademy.service;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LoginService {
    private final Map<String, String> users = new HashMap<>();

    public void menu() {
        Scanner sc = new Scanner(System.in);

        boolean isLoading = true;
        while (isLoading) {

            System.out.println("------------------------");
            System.out.println("| [1] register         |");
            System.out.println("| [2] login            |");
            System.out.println("| [0] exit             |");
            System.out.println("------------------------");

            String choice = sc.nextLine();

            switch (choice) {
                case ("1") -> registration(sc);
                case ("2") -> login(sc);
                case ("0") -> isLoading = false;
                default -> System.out.println("Please select menu item:");

            }
        }
    }

    private void registration(Scanner sc) {
        System.out.println("*** Register ***");
        String userName = getUniqueUsername(sc);
        String password = getCorrectPassword(sc);

        users.put(userName, password);
        System.out.println("User created successfully");
    }

    private void login(Scanner sc) {
        System.out.println("*** Login ***");
        System.out.println("Enter username:");
        String username = sc.nextLine();
        System.out.println("Enter password:");
        String password = sc.nextLine();

        String encodedPassword = users.get(username);
        if (encodedPassword != null && encodedPassword.equals(DigestUtils.sha256Hex(password))) {
            System.out.println("Login successful");
        } else {
            System.out.println("Login error. Please check your credentials");
        }
    }

    private String getCorrectPassword(Scanner sc) {
        String password;
        String repeatPassword;
        String text = "";

        do {
            System.out.println(text);
            System.out.println("Enter password:");
            password = sc.nextLine();
            System.out.println("Repeat password:");
            repeatPassword = sc.nextLine();
            text = "Entered passwords do not match";
        } while (!password.equals(repeatPassword));

        return DigestUtils.sha256Hex(password);
    }

    private String getUniqueUsername(Scanner sc) {
        String name = "";
        String text = "Enter username:";
        do {
            System.out.println(text);
            name = sc.nextLine();
            text = ("This username already exists. Please choose another");
        } while (users.get(name) != null);

        return name;
    }

}
