package lt.codeacademy.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lt.codeacademy.data.*;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class ExamService {

    private List<Exam> exams = new ArrayList<>();
    private List<ExamAnswer> answers = new ArrayList<>();
    private List<StudentExamAnswer> studentExams = new ArrayList<>();
    private ObjectMapper mapper = new ObjectMapper();

    public void createExam() {


        exams.add(new Exam("124", "OOP pagrindai", ExamType.TEST));

        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        ExamAnswer examAnswer = new ExamAnswer();

        examAnswer.setId("124");
        examAnswer.setTitle("OOP pagrindai");
        examAnswer.setExamType(ExamType.TEST);
        examAnswer.setAnswers(List.of(new Answer(1, "a"), new Answer(2, "a"), new Answer(3, "d"), new Answer(4, "c")));

        answers.add(examAnswer);

        File answerFile = new File("answers\\" + examAnswer.getId() + "_answer.json");

        createFile(answerFile);
        writeToFile(answerFile, answers);
//        try {
//            mapper.writeValue(answerFile, examAnswer);
//        } catch (IOException e) {
//            System.out.println(e);
//        }

    }


    public void startExam() {
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        createExam();
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter exam id:");
        String idEntered = sc.nextLine();
        System.out.println("Please enter your student id:");
        String studentId = sc.nextLine();
        System.out.println("Please enter your name:");
        String studentName = sc.nextLine();
        System.out.println("Please enter your surname:");
        String studentSurname = sc.nextLine();
        List<Answer> studentAnswers = new ArrayList<>();
        for (Exam e : exams) {
            if (idEntered.equals(e.getId())) {
                System.out.println("Exam: " + e.getTitle());
                for (ExamAnswer a : answers) {
                    if (a.getId().equals(e.getId())) {
                        List<Integer> questions =
                                a.getAnswers().stream()
                                        .map(Answer::getQuestion)
                                        .collect(Collectors.toList());
                        for (int q : questions) {
                            System.out.println("Question: " + q);
                            System.out.println("Your answer: ");
                            String answerEntered = sc.nextLine();
                            studentAnswers.add(new Answer(q, answerEntered));
                        }
                    }
                }
                ExamAnswer stAnswer = new ExamAnswer(e.getId(), e.getTitle(), e.getExamType(), studentAnswers);
                studentExams.add(new StudentExamAnswer(studentId, studentName, studentSurname, stAnswer));
            }

            File studentExamFile = new File("exams\\" + idEntered + "\\" + studentId + "_studentExam.json");

            createFile(studentExamFile);
            writeToFile(studentExamFile, studentExams);
        }
    }

    public void examStudentResult() {
        List<String > answersToCheck = new ArrayList<>();
        List<Answer> differences = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int grade = 0;
        int count = 0;

        System.out.println("Enter student id:");
        String studentId = sc.nextLine();

        System.out.println("Enter exam id:");
        String examId = sc.nextLine();

        for (StudentExamAnswer studentExam : studentExams) {
            if (studentExam.getId().equals(studentId)) {
                answersToCheck = studentExam.getExamAnswer().getAnswers().stream()
                        .map(Answer::getAnswer)
                        .collect(Collectors.toList());
            }
        }

        for (int i = 0; i < answers.size(); i++) {
            if (answers.get(i).getId().equals(examId)) {
                List<String > finalAnswersToCheck = answersToCheck;
                differences = (answers.get(i).getAnswers().stream()
                        .filter(e -> !finalAnswersToCheck.contains(e))
                        .collect(Collectors.toList()));
            }
        }

        count = differences.size();

        grade = (answersToCheck.size()-count)/answersToCheck.size()*100;

        System.out.println("Your grade for the exam :" + grade);
    }

    public void addExam() {

    }

    public void editExam() {

    }

    public void examAllResults() {

    }

    private void createFile(File file) {
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException exception) {
            System.out.println(exception);
        }
    }

    private void writeToFile(File file, List<?> list) {
        try {
            mapper.writeValue(file, list);
        } catch (IOException exception) {
            System.out.println(exception);
        }
    }

}
