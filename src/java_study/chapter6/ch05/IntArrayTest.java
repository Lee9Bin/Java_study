package java_study.chapter6.ch05;

import java.util.Arrays;
import java.util.stream.IntStream;

public class IntArrayTest {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};

        for (int i : arr){
            System.out.println(i);
        }
//      스트림을 활용
        Arrays.stream(arr).forEach( n-> System.out.println(n) );

        IntStream is = Arrays.stream(arr);
        is.forEach(n-> System.out.println(n));
        //      여기서 is를 다시 쓸수 없다. why? 연산이 수행이 되면 소모가 돼서 다시 생성해야해
//        is.forEach(n-> System.out.println(n));  오류

    }
}
