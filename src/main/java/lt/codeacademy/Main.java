package lt.codeacademy;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lt.codeacademy.data.Answer;
import lt.codeacademy.data.Exam;
import lt.codeacademy.data.ExamAnswer;
import lt.codeacademy.data.ExamType;
import lt.codeacademy.service.ExamService;
import lt.codeacademy.service.LoginService;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

//        LoginService ls = new LoginService();
//        ls.menu();

//        ObjectMapper mapper = new ObjectMapper();
//
//        mapper.enable(SerializationFeature.INDENT_OUTPUT);
//
//        ExamAnswer examAnswer = new ExamAnswer("124", "OOP pagrindai", ExamType.TEST, List.of(new Answer(1, "a"), new Answer(2, "a"), new Answer(3, "d"), new Answer(4, "c")));
//
//        File answerFile = new File("answers\\"+examAnswer.getId()+"_answer.json");
//        if (!answerFile.exists()) {
//            answerFile.createNewFile();
//        }
//
//        mapper.writeValue(answerFile, examAnswer);

        ExamService es = new ExamService();
        es.startExam();


    }
}
