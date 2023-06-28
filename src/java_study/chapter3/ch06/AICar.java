package java_study.chapter3.ch06;

public class AICar extends Car{

    @Override
    public void drive() {
        System.out.println("차가 자율주행을 합니다.");
        System.out.println("차가 방향을 바꿉니다.");
    }

    @Override
    public void stop() {
        System.out.println("장애물에 의해 해주행을 멈춥니다.");
    }
}
