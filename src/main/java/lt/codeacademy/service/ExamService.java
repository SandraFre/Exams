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


    public void createExam() {

        exams.add(new Exam("124", "OOP pagrindai", ExamType.TEST));

        ObjectMapper mapper = new ObjectMapper();

        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        ExamAnswer examAnswer = new ExamAnswer();

        examAnswer.setId("124");
        examAnswer.setTitle("OOP pagrindai");
        examAnswer.setExamType(ExamType.TEST);
        examAnswer.setAnswers(List.of(new Answer(1, "a"), new Answer(2, "a"), new Answer(3, "d"), new Answer(4, "c")));

        answers.add(examAnswer);

        File answerFile = new File("answers\\" + examAnswer.getId() + "_answer.json");

        try {
            if (!answerFile.exists()) {
                answerFile.createNewFile();
            }
        } catch (IOException e) {
            System.out.println(e);
        }

        try {
            mapper.writeValue(answerFile, examAnswer);
        } catch (IOException e) {
            System.out.println(e);
        }

    }


    public void startExam() {
        createExam();
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter exam id:");
        String idEntered = sc.nextLine();
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
                studentExams.add(new StudentExamAnswer(stAnswer));
            }
        }
    }

    public void examStudentResult() {

    }

    public void addExam() {

    }

    public void editExam() {

    }

    public void examAllResults() {

    }

}
