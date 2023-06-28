package java_study.chapter3.ch05;

//추상 메서드를 가진 클래스를 선언
public abstract class Computer {
//  추상메서드는 하위클래스에서 구현해라!
    public abstract void display();
    public abstract void typing();

    void turnOn(){
        System.out.println("전원을 켭니다");
    }

    void turnOff(){
        System.out.println("전원을 끕니다");
    }
}
