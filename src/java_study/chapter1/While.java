package java_study.chapter1;

import java.util.Scanner;

public class While {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
//      while(조건식) 조건식이 참일동안 반복
        while (a < 10){
            System.out.println(a);
            a++;
        }

//      do while문 일단 do를 수행하고 while(조건)에 걸리면 밑에 실행문 실행
        int sum = 0;
        do {
            a = sc.nextInt();
            sum += a;

        }while(a != 0);


        System.out.println(sum);
    }

}

