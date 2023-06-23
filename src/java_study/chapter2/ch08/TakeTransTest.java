package java_study.chapter2.ch08;

import java_study.chapter2.ch07.Person;

public class TakeTransTest {
    public static void main(String[] args){
        Student personJ = new Student("James",5000);
        Student personT = new Student("Tomas",10000);

        Bus bus100 = new Bus(100);
        Subway subwayGreen = new Subway(2);

        personJ.takeBus(bus100);
        personT.takeSubway(subwayGreen);

        personJ.showInfo();
        personT.showInfo();

        bus100.showBusInfo();
        subwayGreen.showBusInfo();

    }
}
