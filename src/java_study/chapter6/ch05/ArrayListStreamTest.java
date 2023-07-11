package java_study.chapter6.ch05;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ArrayListStreamTest {
    public static void main(String[] args) {
        List<String> slist = new ArrayList<>();

        slist.add("이규팔");
        slist.add("이규칠칠");
        slist.add("이규육육육");

        Stream<String> stream = slist.stream();
        stream.forEach(s-> System.out.println(s));

//      원래의 자료를 바꾸지 않아
        slist.stream().sorted().forEach(s-> System.out.println(s));

        slist.stream().map(s -> s.length()).forEach(s-> System.out.println(s));
        slist.stream().filter(s->s.length()>4).forEach(s-> System.out.println(s));
    }

}
