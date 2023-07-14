package java_study.chapter6.ch16;

public class Latte extends Decorator{
    public Latte(Coffee coffee) {
        super(coffee);
    }

    @Override
    public void brewing() {
        super.brewing();
        System.out.print("우유를 추가 ");
        System.out.println("라떼가 만들어졌습니다.");
    }
}
