package java_study.chapter4.ch03;

public class StringTest {
    public static void main(String[] args) {
        String java = new String("java");
        String android = new String("android");

//      concat을 활용한 문자열 연결
//      이때 자바가 가르키는 주소에 android를 붙이는게 아니라
//      새로운 메모리에 javaandorid를 만들어 가르켜 그러면 메모리적으로 계속 생성이되는 문제가 생겨
//      그래서 StringBuilder와 StringBuffer 활용하기!
//        java = java.concat(android);
        System.out.println(java);


//      이렇게 하면 동일한 주소값을 가져
        StringBuilder buffer = new StringBuilder(java);
        buffer.append(android);
        String test = buffer.toString();
        System.out.println(test);
    }
}
