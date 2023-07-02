package java_study.chapter3.ch11;

public class SuperLevel extends PlayerLevel{
    @Override
    public void run() {
        System.out.println("엄청나게 빨리 달립니다.");
    }

    @Override
    public void jump() {
        System.out.println("Super는 2단 jump를 합니다");
    }

    @Override
    public void turn() {
        System.out.println("Super는 부드럽고 빠르게 turn을 합니다");

    }

    @Override
    public void showLevelMessage() {
        System.out.println("****** 고급자 레벨입니다. *******");
    }
}
