package java_study.chapter2.ch11;

public class Car {
    int carId;
    static int serialNum = 10000;

    public Car(){
        serialNum ++;
        carId = serialNum;
    }

    public int getCarNum(){
        return carId;
    }
}
