package lt.codeacademy.data;

import java.util.List;

public class ExamAnswer extends Exam{
    List<Answer> answers;

    public ExamAnswer() {
    }

    public ExamAnswer(List<Answer> answers) {
        this.answers = answers;
    }

    public ExamAnswer(String id, String title, ExamType examType, List<Answer> answers) {
        super(id, title, examType);
        this.answers = answers;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
