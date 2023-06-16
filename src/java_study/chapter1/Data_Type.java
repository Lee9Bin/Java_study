package java_study.chapter1;

public class Data_Type {
    public static void main(String[] args){
//  지료형마다 나타낼수 있는 바이트의 크기가 달라
//      정수형     문자형     실수형     논리형
//1바이트 byte      -        -      boolean
//2바이트 short    char      -         -
//4바이트 int       -      float       -
//8바이트 long      -      double      -
//      int num =12345678900; int의 자료형을 넘어
//      long 자료형을 사용해야해
        long num = 12345678900L;
        System.out.println(num);

//      실수형 표현하기
//      보통 실수를 표현할때 double로 표현해
        double dNum = 3.123123123123;
//      자바에서 실수는 기본타입으로 douㅠle이기 때문에 flot에 담을거면 float으로 다루라는 의미로
        float fNum = 3.1231F;
        System.out.println(dNum);
        System.out.println(fNum);

//      char형 아스키코드로 영어를 숫자로 숫자를 영어로 변환가능
        char ch1 = 'A';
        System.out.println(ch1);
        System.out.println((int)ch1);

        char ch2 = 66;
        System.out.println(ch2);

        int ch3 = 67;
        System.out.println(ch3);
        System.out.println((char)ch3);

        for (int i = 97; i<123; i++){
            System.out.println((char)i);
        }

        boolean isMarried = true;
        System.out.println(isMarried);

//      자바10부터 데이터 타입을 선언하지않고 사용은 가능 단, 지역변수에서
        var i = 10;
        System.out.println(i);
//        i = "test"; 이건 안돼
        i = 11;
        System.out.println(i);

    }
}
