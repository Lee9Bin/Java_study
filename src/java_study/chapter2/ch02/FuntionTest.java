package java_study.chapter2.ch02;

public class FuntionTest {
//  반환값이 있으면 해당 자료형을 쓰고 없다면 void, 함수이름, (매개변수가 있다면 쓴다)
    public static int addNum(int num1, int num2) {
        int result;
        result = num1 + num2;
        return result;
    }

    public static void sayHello(String greeting) {
        System.out.println(greeting);
    }

    public static int calcSum() {
        int sum = 0;
        int i;
        for(i = 0; i<=100; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        int n1 = 10;
        int n2 = 20;
        int total = addNum(n1, n2);

        sayHello("안녕하세요");
        int num = calcSum();

        System.out.println(total);
        System.out.println(num);
    }
//스택: 함수가 호출될 때 지역변수들이 사용하는 메모리
//함수의 수행이 끝나면 자동으로 반환되는 메모리
//함수와 메서드의 차이
//함수는 어디 속해있는게 아닌 단독 모듈
//메서드는 함수의 일종이지만 클래스안에 속해있고 클래스의 멤버변수들을 활용해서 구현
//멤버변수는 클래스의 시작할때 선언하는거라 생각하자 우선
//지역변수는 함수내에서 사용되는 변수라 생각
}
