package java_study.chapter2.ch03;

public class Student {
    public int studentId;
    public String studentName;
    public String address;
//  위 이것이 멤버 변수
    public void showStudentInfo(){
        System.out.println(studentId + " 학번 학생의 이름은 " + studentName + "이고, 주소는 " + address +"입니다.");
    }
//학생 이름을 반환하는 메서드
    public String getStudentName(){
        return studentName;
    }
//학생 이름을 바꾸는 메서드
    public void setStudentName(String name){
        studentName = name;
    }
}
