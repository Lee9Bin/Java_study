package java_study.chapter5.ch02;

import java.util.HashSet;

public class HashsetTest {

    public static void main(String[] args) {

        HashSet<String> hashSet = new HashSet<String>();
        hashSet.add(new String("김유신"));
        hashSet.add(new String("이순신"));
        hashSet.add(new String("홍연의"));
        hashSet.add(new String("강감찬"));
        hashSet.add(new String("강감찬"));
        //파이썬에서 set과 동일
        System.out.println(hashSet);
    }
}
