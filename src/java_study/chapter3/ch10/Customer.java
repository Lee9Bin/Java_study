package java_study.chapter3.ch10;
//여러개 implements 할때 밑에와 같이 작성
public class Customer implements buy,sell{

    @Override
    public void buy() {
        System.out.println("Customer buy");
    }

    @Override
    public void sell() {
        System.out.println("Customer sell");
    }
//  이렇게까지만 쓰면 에러가 떠 왜? buy와 sell쪽에 디폴트 메서드가 있어서 모호해졌기 때문이야
//  그래서 재정의 해야해
    @Override
    public void order() {
//        buy.super.order();이려면 buy꺼
//        sell.super.order();이려면 sell꺼
//        직접 재정의도 가능
        System.out.println("customer order");
    }

    public void hello(){
        System.out.println("손님 어서오세요");
    }
}
