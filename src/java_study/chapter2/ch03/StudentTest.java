package java_study.chapter2.ch03;
//student 클래스를 써주는 메인을 포함한 클래스를 선언
public class StudentTest {
    public static void main(String[] args){
//      클래스이름 객체이름선언 = new 생성자, 동적메모리 heap에 할당
        Student studentLee = new Student();
        studentLee.studentName = "이순신";
        studentLee.address = "서울";


        studentLee.showStudentInfo();

        Student studentKim = new Student();
        studentKim.studentName = "김유신";
        studentKim.address = "경주";

        studentKim.showStudentInfo();

        System.out.println(studentKim.getStudentName());
        System.out.println(studentKim);
//@뒤에 있는게 주소값 즉 각각 heap에 인스턴스가 저장된 위치라 생각
//        객체 : 객체 지향 프로그램의 대상, 생성된 인스턴스
//        클래스 : 객체를 프로그래밍 하기위해 코드로 정의해 놓은 상태
//        인스턴스 : new 키워드를 사용하여 클래스를 메모리에 생성한 상태
//        멤버 변수 : 클래스의 속성, 특성
//        메서드 : 멤버 변수를 이용하여 클래스의 기능을 구현한 함수
//        참조 변수 : 메모리에 생성된 인스턴스를 가리키는 변수
//        참조 값 : 생성된 인스턴스의 메모리 주소 값
//java_study.chapter2.ch03.Student@783e6358
//java_study.chapter2.ch03.Student@17550481
    }
}
