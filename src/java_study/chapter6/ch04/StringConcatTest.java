package java_study.chapter6.ch04;

public class StringConcatTest {
    public static void main(String[] args) {
//      람다식 사용
        String str1 = "123";
        String str2 = "456";
        StringConcat concat = (s1 , s2) ->{
            System.out.println(s1+','+s2);};
        concat.makeString(str1,str2);

//      계속해 오던 객체지프로그래밍
//      인터페이스는 인스턴스화 될수없다. 저번에 했지? 기억하자
        StringConcatImple strImple = new StringConcatImple();
        strImple.makeString("abc","def");
    }
}
