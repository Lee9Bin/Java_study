package java_study.chapter2.ch12;

import java.util.ArrayList;
//Book 클래스가 같은 패키지내에 없다면 import 패키지이름.클래스이름;
public class BookArrayList {
    public static void main(String[] args) {
//  기존의 배열은 매번 크기를 선언해줘야해 그래서 등장하는게 java.util에서 제공하는 ArrayList
//      ArrayList <데이터타입> 변수 = new ArrayList<데이터타입(여기는 생략가능)>();
        ArrayList<Book> arr = new ArrayList<>();
//      파이썬에 append와 같다.
        arr.add(new Book("가","홍"));
        arr.add(new Book("가나","홍길"));
        arr.add(new Book("가나다","홍길동"));
        arr.add(new Book("가나다라","홍길동!"));

        for (int i = 0; i < arr.size(); i++){
            System.out.println(arr.get(i).getAuthor());
        }
    }
}
