package java_study.chapter6.ch07;

import java.util.ArrayList;
import java.util.Arrays;

public class TravelTest {
    public static void main(String[] args) {
        ArrayList<Customer> customerList = new ArrayList<>();

        Customer Lee = new Customer("이순신",40,100);
        Customer Kim = new Customer("김유신",20,100);
        Customer Hong = new Customer("홍길동",13,50);

        customerList.add(Lee);
        customerList.add(Kim);
        customerList.add(Hong);
        System.out.println("== 고객 명단 추가된 순서대로 출력 ==");
        for (Customer c : customerList){
            System.out.println("이름: "+c.getName()+"나이 : " + c.getAge() + "비용 : "+ c.getCost());
        }
        System.out.println("== 고객 명단 추가된 순서대로 출력 ==");
        customerList.stream().forEach(s-> System.out.println("이름: "+s.getName()+"나이 : " + s.getAge() + "비용 : "+ s.getCost()));
        System.out.println("총비용: "+customerList.stream().mapToInt(s->s.getCost()).sum());
        customerList.stream().filter(s->s.getAge()>=20).map(s->s.getName()).sorted().forEach(c-> System.out.println("이름: "+c));

    }
}
