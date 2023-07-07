package java_study.chapter6.ch03;

public class AddTest {

    public static void main(String[] args) {

        Add add = (x , y) ->{return x+y;};
        System.out.println(add.add(2,4));
        System.out.println();

        Max max = (x, y) ->{return x>y ? x : y;};
        System.out.println(max.getMax(10,20));
    }
}
