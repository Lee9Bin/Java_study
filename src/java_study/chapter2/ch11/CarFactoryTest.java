package java_study.chapter2.ch11;

public class CarFactoryTest {

    public static void main(String[] args) {
//      new 생성자가 아닌 싱글톤 패턴으로 참초
        CarFactory factory = CarFactory.getInstance();
//    반환타입                   메서드가 CarFactory클래스안에 있다라고 생각
//    그러면 클래스 작성시 =뒤에 클래스를 확인해 메서드를 작성한다 이때 맨앞에 반환 타입을 생각하자.
//    클래스 변수 = new 클래스()와 같은거야
//        public Car createCar(){
//            Car car = new Car();
//            return car;
//        } 결국 createCar를 통해 객체를 생성해서 mySonata에 할당
        Car yourSonata = factory.createCar();
        Car mySonata = factory.createCar();

        System.out.println(mySonata.getCarNum());     //10001 출력
        System.out.println(yourSonata.getCarNum());   //10002 출력
    }
}
