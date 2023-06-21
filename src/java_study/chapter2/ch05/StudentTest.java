package java_study.chapter2.ch05;

public class StudentTest {

    public static void main(String[] args) {

        Student studentLee = new Student(100, "이규");
        studentLee.setKoreaSubject("국어", 100);
        studentLee.setMathSubject("수학", 95);


        Student studentKim = new Student(101, "이빈");
        studentKim.setKoreaSubject("국어", 80);
        studentKim.setMathSubject("수학", 99);

        studentLee.showStudentSocre();
        studentKim.showStudentSocre();
    }

}
