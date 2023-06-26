package java_study.chapter3.ch01;

public class Customer {
//    고객 아이디, 고객 이름, 고객 등급, 보너스 포인트, 보너스 포인트 적립비율
//    고객의 정보이므로 private제어자로 했지만 상속관계에서는 사용이 돼야 하기 때문에
//    같은패키지내, 하위클래스는 접근을 할 수 있게 하기위해서는 protected로 제어자 선언
//    private int customerId;
//    private String customerName;
//    private String customerGrade;
    protected int customerId;
    protected String customerName;
    protected String customerGrade;
    int bonusPoint;
    double bonusRatio;

//  상속으로 구현하지 않는다면 밑에와 같이 추가해서 기능을 추가할수 있지만
//  고객에 따라 등급을 바꿔줘여 하고 계산의 로직인 if를 써서 변경이 돼야해 또한 요구사항은 계속 변경이 되고 추가가 되기때문에 클래스의 코드가 난잡해져
//  즉, 일반고객이 아닌데 가져야할 기능까지 들어가고 속성까지 들어가서 클래스의 단일성이 깨져 ---->if else가 많다? 상속을 생각해보자
//    String agentId;
//    double saleRatio;

    public Customer(){
        customerGrade = "BRONZE";
        bonusRatio = 0.01;
        System.out.println("Customer생성자 호출");
    }

    public int calcPrice(int price){
        if (customerGrade == "BRONZE"){
            bonusPoint += price * bonusRatio;}
//        else if (getCustomerGrade == "GOLD")
        return price;
    }

    public String showCustomerInfo(){
        return customerName + "님의 등급은 " + customerGrade +"이며, 보너스 포인트는 " + bonusPoint + "입니다.";
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerGrade() {
        return customerGrade;
    }

    public void setCustomerGrade(String customerGrade) {
        this.customerGrade = customerGrade;
    }
}
