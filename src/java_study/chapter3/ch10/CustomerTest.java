package java_study.chapter3.ch10;

public class CustomerTest {
    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.buy();
        customer.sell();
        customer.order();
        customer.hello();

//      타입 변경 가능
        buy buyer = (buy)customer;
        buyer.order();
    }
}
