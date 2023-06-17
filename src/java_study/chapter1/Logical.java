package java_study.chapter1;

public class Logical {
    public static void main(String[] args){
        int a = 1;
        int b = 10;

//      논리 연산자 값 담기
        boolean result = (a>b);
        System.out.println(result);
        result = (a<b);
        System.out.println(result);
//      그리고 연산 둘다 참이여야 참 하나라도 거짓이면 거짓
        result = ((a>b) && a> 0);
        System.out.println(result);
        //하나라도 참이면 참
        result = ((a>b) || a > 0);
        System.out.println(result);
    }
}
