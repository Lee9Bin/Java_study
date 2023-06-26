package java_study.chapter3.ch01;

public class CustomerTest {
    public static void main(String[] args) {
        Customer customerLee = new Customer();
//        protected: 같은 패키지내에서 사용은 가능
//        customerLee.customerName = "이규팔";
//        System.out.println(customerLee.customerName);
        customerLee.setCustomerName("이규팔");
        customerLee.setCustomerId(10010);
        customerLee.bonusPoint = 1000;
        System.out.println(customerLee.showCustomerInfo());

        VIPCustomer customerOh = new VIPCustomer();
//      상위클래스의 멤버변수를 사용할 수 있는 이유는 하위클래스 생성자에서 반드시 상위클래스 생성자를 호출하기 때문
//      하위클래스의 생성자에서 호출하는 코드가 없는데 어떻게? super();키워드를 통해 호출하는데 안적혀 있다면 디폴트값으로 자동으로 들어
//      하지만 상위클래스에서 기본생성자가 아니라면 super();가 선언이 되므로 오류가 생겨 그래서 형태를 맞춰줘야해
//      ex)상위클래스 생성장(int, String) 하위클래스에서는 super(int, String)이런식으로 코드작성
        customerOh.setCustomerName("오송");
        customerOh.setCustomerId(20010);
        customerOh.bonusPoint = 2000;
//      상속을 받았기때문에 사용가능
        System.out.println(customerOh.showCustomerInfo());

    }
}
