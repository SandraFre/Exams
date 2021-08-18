package lt.codeacademy.service;

import lt.codeacademy.data.Exam;
import lt.codeacademy.data.Student;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ExamService {

    private final Map<String, Student> students = new HashMap<>();

    public void startExam(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your student id:");
        String studentId = sc.nextLine();
        System.out.println("Enter your name:");
        String studentName = sc.nextLine();
        System.out.println("Enter your surname:");
        String studentSurname = sc.nextLine();

        Student student = new Student(studentId, studentName,studentSurname);

        students.put(studentId, student);



    }

}
