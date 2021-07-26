package lt.codeacademy.data;

public class Exam {
    private int id;
    private String title;
    private ExamType examType;

    public Exam() {
    }

    public Exam(int id, String title, ExamType examType) {
        this.id = id;
        this.title = title;
        this.examType = examType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ExamType getExamType() {
        return examType;
    }

    public void setExamType(ExamType examType) {
        this.examType = examType;
    }
}
