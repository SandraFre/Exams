package lt.codeacademy.data;

public class StudentExamAnswer extends Student{
    private ExamAnswer examAnswer;

    public StudentExamAnswer(ExamAnswer examAnswer) {
        this.examAnswer = examAnswer;
    }

    public StudentExamAnswer(String id, String name, String surname, ExamAnswer examAnswer) {
        super(id, name, surname);
        this.examAnswer = examAnswer;
    }

    public ExamAnswer getExamAnswer() {
        return examAnswer;
    }

    public void setExamAnswer(ExamAnswer examAnswer) {
        this.examAnswer = examAnswer;
    }
}
