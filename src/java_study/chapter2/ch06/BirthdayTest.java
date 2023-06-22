package java_study.chapter2.ch06;

public class BirthdayTest {
    public static void main(String[] args) {
        Birthday date = new Birthday();

        date.setYear(2019);
        date.setMonth(77);
        date.setDay(100);
        date.showBirthday();

        date.setYear(1997);
        date.setMonth(2);
        date.setDay(28);
        date.showBirthday();
    }

//  pricate로 제어해 정보은닉을 한다.
//  why? 외부에서 접근가능 정보를 최소화 시키고 객체의 오류를 방지하여
//  클라이언트 객체가 더 효율적으로 갹체를 활용할 수 있도록 해준다.
}
