package java_study.chapter3.ch11;
//추상클래스를 상속받으려면 추상메서드를 오버라이딩 해서 구현 하거나 내가 abstract가 또 되거나
public class BeginnerLevel extends PlayerLevel{

    @Override
    public void run() {
        System.out.println("천천히 달립니다.");
    }

    @Override
    public void jump() {
        System.out.println("Beginner는 jump를 못합니다.");
    }

    @Override
    public void turn() {
        System.out.println("Beginner는 turn을 못합니다.");
    }

    @Override
    public void showLevelMessage() {
        System.out.println("****** 초급자 레벨입니다. *******");
    }
}
