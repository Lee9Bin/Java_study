package java_study.chapter1;

import java.util.ArrayList;

public class Array_2 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
//      파이썬에서 append와 같음
        list.add(1); // 1 삽입
        list.add(3); // 1,3
        list.add(1, 2); // 	index 1에 2 추가

        System.out.println(list);

        list.remove(2); // 2번 인덱스 삭제 => remove(index) 파이썬과 동일
        System.out.println(list);

        list.clear(); // 리스트의 모든 값 삭제
        System.out.println(list);

        list.add(3);
        list.add(-1);
//                 (indexOf(값)) 값의 인덱스를 가져와 contains(값) 값이 존재하는지 확인
        list.remove(list.indexOf(2)); // 리스트에 2를 포함한 인덱스 리턴 후 삭제, 없으면 -1을 리턴 여기서는 자바는 음수 인덱스가 없기에 오류발생
    }
}
