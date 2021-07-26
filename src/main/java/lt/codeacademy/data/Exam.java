package lt.codeacademy.data;

public class Exam {
    private String id;
    private String title;
    private ExamType examType;

    public Exam() {
    }

    public Exam(String id, String title, ExamType examType) {
        this.id = id;
        this.title = title;
        this.examType = examType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
