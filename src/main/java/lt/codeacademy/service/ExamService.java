package lt.codeacademy.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lt.codeacademy.data.*;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class ExamService {

    List<Exam> exams = new ArrayList<>();
    ExamAnswer examAnswer = new ExamAnswer();

    public void createExam() {

        exams.add(new Exam("124", "OOP pagrindai", ExamType.TEST));

        ObjectMapper mapper = new ObjectMapper();

        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        examAnswer.setId("124");
        examAnswer.setTitle("OOP pagrindai");
        examAnswer.setExamType(ExamType.TEST);
        examAnswer.setAnswers(List.of(new Answer(1, "a"), new Answer(2, "a"), new Answer(3, "d"), new Answer(4, "c")));

        File answerFile = new File("answers\\" + examAnswer.getId() + "_answer.json");

        try {
            if (!answerFile.exists()) {
                answerFile.createNewFile();
            }
        } catch (IOException e){
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
