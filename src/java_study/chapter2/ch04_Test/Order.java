package java_study.chapter2.ch04_Test;

public class Order {
    String orderNumber;
    String orderPhone;
    String orderAddress;
    String  date;
    String time;
    int price;
    String menuNum;
    public Order(String orderNumber, String orderPhone, String orderAddress, String date, String time
    , int price, String menuNum){
        this.orderNumber = orderNumber;
        this.orderPhone = orderPhone;
        this.orderAddress = orderAddress;
        this.date = date;
        this.time = time;
        this.price = price;
        this.menuNum = menuNum;
    }
    public void getOrderInfo(){
        System.out.println("주문 접수 번호 : "+orderNumber);
        System.out.println("주문 핸드폰 번호 : "+orderPhone);
        System.out.println("주문 집 주소 : "+orderAddress);
        System.out.println("주문 날짜 : "+date);
        System.out.println("주문 시간 : "+time);
        System.out.println("주문 가격 : "+price);
        System.out.println("메뉴 번호 : "+menuNum);

    }
}
