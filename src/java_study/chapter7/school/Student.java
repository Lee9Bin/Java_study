package java_study.chapter7.school;

import java.util.ArrayList;

public class Student {
    private String name; //학생 이름
    private int studentId; //학번
    private Subject majorSubject;  //전공과목
    private ArrayList<Score> scoreList = new ArrayList<>(); //과목 점수들

    public ArrayList<Score> getScoreList() {
        return scoreList;
    }

    public void setScoreList(ArrayList<Score> scoreList) {
        this.scoreList = scoreList;
    }

    public Student(int studentId, String name, Subject majorSubject){
        this.name = name;
        this.studentId = studentId;
        this.majorSubject = majorSubject;
    }

    public void addSubjectScore(Score score){
        scoreList.add(score);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public Subject getMajorSubject() {
        return majorSubject;
    }

    public void setMajorSubject(Subject majorSubject) {
        this.majorSubject = majorSubject;
    }
}
