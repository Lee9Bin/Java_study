package java_study.chapter7.school;
import java.util.ArrayList;

public class School {
    private static School instance = new School();

    private static String SCHOOL_NAME = "Sungbo";
    private static ArrayList<Subject> subjectsList= new ArrayList<>();
    private static ArrayList<Student> studentsList= new ArrayList<>();

    private School(){

    }
    public static School getInstance(){
        if(instance == null){
            instance = new School();
        }
        return instance;
    }

    public void addStudent(Student student){
        studentsList.add(student);
    }
    public void addSubject(Subject subject){
        subjectsList.add(subject);
    }
    public static void setInstance(School instance) {
        School.instance = instance;
    }

    public static String getSchoolName() {
        return SCHOOL_NAME;
    }

    public static void setSchoolName(String schoolName) {
        SCHOOL_NAME = schoolName;
    }

    public static ArrayList<Subject> getSubjectsList() {
        return subjectsList;
    }

    public static void setSubjectsList(ArrayList<Subject> subjectsList) {
        School.subjectsList = subjectsList;
    }

    public static ArrayList<Student> getStudentsList() {
        return studentsList;
    }

    public static void setStudentsList(ArrayList<Student> studentsList) {
        School.studentsList = studentsList;
    }
}
