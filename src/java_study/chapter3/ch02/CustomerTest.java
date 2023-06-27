package java_study.chapter3.ch02;

public class CustomerTest {
    public static void main(String[] args) {
        Customer customerLee = new Customer(10010,"이규팔");
        customerLee.bonusPoint = 1000;
        int price = customerLee.calcPrice(1000);
        System.out.println(price);
        System.out.println(customerLee.showCustomerInfo());

        VIPCustomer customerOh = new VIPCustomer(20010,"오송삼");
        customerOh.bonusPoint = 2000;
        price = customerOh.calcPrice(1000);
        System.out.println(price);
        System.out.println(customerOh.showCustomerInfo());

//      메서드 재정의에서 이 경우는 어떻게 될까?
        Customer customerPark = new VIPCustomer(123123,"박지성");
//      자바에서는 항상 인스턴스의 메서드가 호출 된다.
//      (가상메모리의 원리에 의해서 메서드 이름이 같더라도 재정의 되면서 다른 주소를 할당 받게 된다 생각)
//      자바의 모든 메서드는 가상메서드다.
        customerPark.calcPrice(1000);
    }
}
