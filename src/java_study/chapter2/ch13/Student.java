package java_study.chapter2.ch13;

import java.util.ArrayList;

public class Student {
    int studentId;
    String studentName;
    ArrayList<Subject> subjectList;
    public Student(){
    }

    public Student(int studentId, String studentName){
        this.studentId = studentId;
        this.studentName = studentName;
        subjectList = new ArrayList<>();
    }
    public void addSubject(String subjectName, int subjectPoint){
        Subject subject = new Subject();

        subject.setSubjectName(subjectName);
        subject.setSubjectPoint(subjectPoint);
        subjectList.add(subject);
    }

    public void showStudentInfo(){
        int total = 0;

        for(Subject s : subjectList){
            System.out.println(s.getSubjectName());
//            total += s.getSubjectPoint();
//            System.out.println("학생 " + studentName + "의 " + s.getSubjectName() + " 과목 성적은 " +
//                    s.getSubjectPoint() + "입니다.");

        }
}}
