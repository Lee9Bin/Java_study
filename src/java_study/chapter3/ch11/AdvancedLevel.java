package java_study.chapter3.ch11;

public class AdvancedLevel extends PlayerLevel{
    @Override
    public void run() {
        System.out.println("빨리 달립니다.");
    }

    @Override
    public void jump() {
        System.out.println("Advanced는 1단 jump를 합니다");
    }

    @Override
    public void turn() {
        System.out.println("Advanced는 부드럽게 turn을 합니다");

    }

    @Override
    public void showLevelMessage() {
        System.out.println("****** 중급기 레벨입니다. *******");
    }
    public void cry(){

    }
}
