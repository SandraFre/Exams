package lt.codeacademy.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lt.codeacademy.data.Student;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class RegisterService {

    protected Map<String, String> teachersList = new HashMap<>();
    protected Map<String, String> studentsList = new HashMap<>();

    protected List<Student> allStudents = new ArrayList<>();
    protected ObjectMapper mapper = new ObjectMapper();
    protected File studentFile = new File("students.json");

    protected void teacherRegistration(Scanner sc) {
        System.out.println("*** Teacher Registration ***");
        String userName = getUniqueUsername(sc);
        String password = getCorrectPassword(sc);

        teachersList.put(userName, password);
        System.out.println("Teacher created successfully");
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
        } while (teachersList.get(name) != null);

        return name;
    }

    protected void studentRegistration(Scanner sc) {
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        if (allStudents != null && !studentFile.exists()) {
            createFile();
        }

        Student student = new Student();
        System.out.println("*** Student Registration ***");
        System.out.println("Enter your student ID:");
        String id = sc.nextLine();
        student.setId(id);
        System.out.println("Enter you name:");
        String name = sc.nextLine();
        student.setName(name);
        System.out.println("Enter you surname:");
        String surname = sc.nextLine();
        student.setSurname(surname);

        writeToFile(student);

        String password = getCorrectPassword(sc);

        studentsList.put(id, password);
        System.out.println("Student created successfully");
    }

    private void createFile() {
        try {
                studentFile.createNewFile();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private void writeToFile(Student student){
        try {
            if (allStudents!=null &&!allStudents.isEmpty()){
                allStudents = mapper.readValue(studentFile, new TypeReference<>() {
                });
            }

            allStudents.add(student);

            mapper.writeValue(studentFile, allStudents);
        } catch (IOException e){
            System.out.println(e);
        }

    }

}
