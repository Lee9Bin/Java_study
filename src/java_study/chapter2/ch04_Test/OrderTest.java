package java_study.chapter2.ch04_Test;

public class OrderTest {
    public static void main(String[] args){
        Order orders = new Order("202011020003","01023450001","서울시 강남구 역삼동 111-333",
                "20201102","130258",35000,"0003");
        orders.getOrderInfo();
    }
}
