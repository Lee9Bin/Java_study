package java_study.chapter1;
//증감 연산자
public class Operator {
    public static void main(String[] args){
        int a = 100;
//      증감 연산자가 변수 앞에 있으면 a에 1을 더하고 b에 담아
        int b = ++a;
        System.out.println(b);
        System.out.println(a);
//      변수 뒤에 있으면 a를 먼저 담고 +1
        int c = a++;
        System.out.println(b);
        System.out.println(a);
    }
}
