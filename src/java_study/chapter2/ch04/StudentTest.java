package java_study.chapter2.ch04;

public class StudentTest {
    public static void main(String[] args) {
        Student student1 = new Student();
//  멤버변수는 초기화가 돼 String은 null로 int는 0
//  지역변수는 초기화가 안돼서 선언하고 값을 넣어야됨
        System.out.println(student1.shwoStudentInfo());

        Student student2 = new Student(12345,"이규빈",3);
        System.out.println(student2.shwoStudentInfo());

    }
}
