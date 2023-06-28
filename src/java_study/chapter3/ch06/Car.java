package java_study.chapter3.ch06;

public abstract class Car {
    public abstract void drive();
    public abstract void stop();

    public void startCar(){
        System.out.println("시동을 켭니다.");
    }
    public void endCar(){
        System.out.println("시동을 끕니다.");
    }

    public void washCar(){
//     후크 메서드: 상위클래스에서 필요한 기능일때 하위클래스들 중 필요한 친구가 재정의 할 수 있게
    }
//템플릿 메서드 시나리오를 짜는거지
    final public void run(){
        startCar();
        drive();
        stop();
        endCar();
    }
}
