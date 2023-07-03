package java_study.chapter4.ch02;

public class EqualsTest {
    public static void main(String[] args) {
        Student std1 = new Student(100,"Lee");
        Student std2 = new Student(100,"Lee");
        Student std3 = std1; // 같은 주소를 가르치게

//      두개는 다른 객체이므로 false 근데 논리적으로는 같은데 어떻게 해야할까?
//      실제 주소는 다르지만
        System.out.println(std1 == std2);
//      equals를 재정의 해주면 돼
//      논리적으로 같다
        System.out.println(std1.equals(std2));

//      당연히 같은 주소를 가르키게 했으니 true
        System.out.println(std1 == std3);
        System.out.println(std1.equals(std3));

    }
}
