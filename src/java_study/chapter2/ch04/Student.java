package java_study.chapter2.ch04;
//생성자
public class Student {
    public int studentNumber;
    public String studentName;
    public int grade;
//기본적으로 생성자가 선언이 안되면 컴파일러가 생성자 코드를 붙여줘
//그래서 생성자에서 무슨 작업을 하고 싶으면 선언해서 코드짜기
//여러 생성자를 만드는 것 생성자 오버로딩
    public Student(){}
    public Student(int studentNumber,String studentName, int grade){
//        System.out.println("생성됨");
//      멤버변수를 가르키고       매개변수를 가르켜
        this.studentNumber = studentNumber;
        this.studentName = studentName;
        this.grade = grade;
    }
    public String shwoStudentInfo(){
        return studentName + "학생의 학번은 " + studentNumber +"이고, " + grade + "학년 입니다.";
    }
}
