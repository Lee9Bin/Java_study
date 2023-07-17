package java_study.chapter7;
import java.util.ArrayList;

public class Student {
    private String name;
    private int studentId;
    private Subject majorSubject;
    public ArrayList<Score> scoreList = new ArrayList<>();

    public Student(String name, int studentId, Subject majorSubject){
        this.name = name;
        this.studentId = studentId;
        this.majorSubject = majorSubject;
    }
}
