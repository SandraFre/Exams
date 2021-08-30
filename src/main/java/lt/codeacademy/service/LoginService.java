package lt.codeacademy.service;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.Scanner;

public class LoginService extends RegisterService {
    StudentMenuService ss = new StudentMenuService();
    TeacherMenuService ts = new TeacherMenuService();

    public void teacherLogin(Scanner sc) {
        System.out.println("*** Teacher Login ***");
        System.out.println("Enter username:");
        String username = sc.nextLine();
        System.out.println("Enter password:");
        String password = sc.nextLine();

        String encodedPassword = teachersList.get(username);
        if (encodedPassword != null && encodedPassword.equals(DigestUtils.sha256Hex(password))) {
            System.out.println("Login successful");
            ts.menu();
        } else {
            System.out.println("Login error. Please check your credentials");
        }
    }

    public void studentLogin(Scanner sc) {
        System.out.println("*** Student Login ***");
        System.out.println("Enter student id:");
        String id = sc.nextLine();
        System.out.println("Enter password:");
        String password = sc.nextLine();

        String encodedPassword = studentsList.get(id);
        if (encodedPassword != null && encodedPassword.equals(DigestUtils.sha256Hex(password))) {
            System.out.println("Login successful");
            ss.menu();
        } else {
            System.out.println("Login error. Please check your credentials");
        }
    }



}
