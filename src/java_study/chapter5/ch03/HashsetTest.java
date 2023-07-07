package java_study.chapter5.ch03;

import java.util.HashSet;
//set인터페이스: 순서와 관계없이 중복을 허용하지 않고 유일한 값을 관리하는데 필요한 메서드가 선언된다.
//set 인터페이스를 구현한 클래스와 멤버의 중복 여부를 체크하기 위해 인스턴스의 동일성을 확인해야 한다.
public class HashsetTest {

    public static void main(String[] args) {

        HashSet<String> hashSet = new HashSet<String>();
//      add함수를 호출하면 내부적으로 equals와 hashcode매서드가 실행이 되면서 중복여부를 체크한다.
        hashSet.add(new String("김유신"));
        hashSet.add(new String("이순신"));
        hashSet.add(new String("홍연의"));
        hashSet.add(new String("강감찬"));
        hashSet.add(new String("강감찬"));
        //파이썬에서 set과 동일
        System.out.println(hashSet);
    }
}
