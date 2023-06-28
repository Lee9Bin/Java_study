package java_study.chapter3.ch03;

import java.util.ArrayList;
import java.util.Arrays;

public class CustomerTest {
    public static void main(String[] args) {

        ArrayList<Customer> customerList= new ArrayList<>();

        Customer customerT = new Customer(10010,"Tom");
        Customer customerJ = new Customer(10020,"James");
        Customer customerA = new GoldCustomer(10030,"Anddy");
        Customer customerP = new GoldCustomer(10040,"Poby");
        Customer customerL = new VIPCustomer(10050,"Leo");
//      3종류의 고객이 있지만 모두 상위클래스로 핸들링 하고 배열에 담았다.
        customerList.add(customerT);
        customerList.add(customerJ);
        customerList.add(customerA);
        customerList.add(customerP);
        customerList.add(customerL);

        for (Customer cus : customerList){
            System.out.println(cus.showCustomerInfo());
        }
        int price = 10000;
        for (Customer cus : customerList){
            System.out.println(cus.calcPrice(price));
            System.out.println(cus.bonusPoint);
        }
    }
}
