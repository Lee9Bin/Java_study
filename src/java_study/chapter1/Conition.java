package java_study.chapter1;

import java.util.Scanner;

public class Conition {
    public static void main(String[] args){
//      입력 받기위해서 사용하는 스캐너 객체 System.in은 입력이라고 생각하면 돼 System.out.print()는 출력키워드
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
//      조건 연산자 (조건식) ? 참일떄의 값 : 거짓일떄의 값
        int result = (a >b) ? a:b;
        System.out.println(result);

        int num1 = 5;  	// 00000101
        int num2 = 10; 	// 00001010
//      둘중에 하나라도 1이면 1
        System.out.println(num1 | num2);
//      둘다 1이여야 1
        System.out.println(num1 & num2);
//      다르면 1 같으면 0
        System.out.println(num1 ^ num2);
//      보수
        System.out.println(~num1);
//      쉬프트 연산자 비트를 << n, >> n 방향으로 n만큼 밀어준다고 생각
        System.out.println(num1 << 2);
        System.out.println(num1);

    }
}
