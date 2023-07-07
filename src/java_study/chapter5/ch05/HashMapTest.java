package java_study.chapter5.ch05;
import java.util.HashMap;

//key는 중복 될수 없고 검색을 위한 자료구조
//equals()와 hashcode를 구현해야한다.

public class HashMapTest {
    public static void main(String[] args) {
        HashMap<String,Integer> hashMap = new HashMap<String,Integer>();

        hashMap.put("강감찬",2);
        hashMap.put("홍길동",1);
        hashMap.put("이순신",3);

        System.out.println(hashMap);
    }

}
