package java_study.chapter2.ch13;

import java.security.PublicKey;
import java.util.ArrayList;

public class Student {
//  Student 객체의 속성들을 멤버변수로 선언
    String studentName;
    int studentId;
    ArrayList<Subject> subjectList;
    static int serialNum = 1000;

//  default생성자
    public Student(){

    }

    public Student(int studentId, String studentName){
//      this는 클래스내의 멤버변수라는것을 가르켜준다
        this.studentId = studentId;
        this.studentName = studentName;
//      학생이 생성되면 그학생의 배열도 만들어줘야지
        subjectList = new ArrayList<>();
    }

    public void addSubject(String name, int point){
        Subject subject = new Subject();
        subject.setName(name);
        subject.setPoint(point);
        System.out.println(subject);
//      인스턴스를 가르키는 subject를 배열에 추가
        subjectList.add(subject);
    }

    public void showStudentInfo(){
        int total = 0;
        for (Subject s : subjectList){
            total += s.getPoint();
            System.out.println("학생 " + studentName+"의 " + s.getName()+" 의 과목 성적은 " + s.getPoint()+"입니다.");
        }
        System.out.println("학생 " + studentName+"의 총점은 " + total + "입니다.");
    }
}
