package lt.codeacademy.data;

public class StudentGrade extends Student {
    private int grade;

    public StudentGrade() {
    }

    public StudentGrade(String id, String name, String surname, int grade) {
        super(id, name, surname);
        this.grade = grade;
    }
}
