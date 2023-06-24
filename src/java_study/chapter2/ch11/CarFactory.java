package java_study.chapter2.ch11;

public class CarFactory {
//  외부에 생성자를 제공하지 않을것이기 때문에 디폴트 생성자를 private로 선언하고 클래스내부에 생성자 작성
    private static CarFactory instance = new CarFactory();
    private CarFactory(){

    }

//  static 클래스자야이름 메서드이름
    public static CarFactory getInstance(){
        return instance;
    }

    public Car createCar(){
        Car car = new Car();
        System.out.println(car);
        return car;
    }
}
