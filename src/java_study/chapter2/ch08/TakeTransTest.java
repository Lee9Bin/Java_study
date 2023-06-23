package java_study.chapter2.ch08;

import java_study.chapter2.ch07.Person;

public class TakeTransTest {
    public static void main(String[] args){
        Student personJ = new Student("James",5000);
        Student personT = new Student("Tomas",10000);
        Student personE = new Student("Edward",20000);

        Bus bus100 = new Bus(100);
        Bus bus200 = new Bus(200);

        Subway subwayGreen = new Subway(2);
        Taxi goodTaxi = new Taxi("잘 간다 운수택시");

        personJ.takeBus(bus100);
        personJ.takeBus(bus100);
        personJ.takeBus(bus200);
        personT.takeSubway(subwayGreen);
        personE.takeTaxi(goodTaxi);

        personJ.showInfo();
        personT.showInfo();
        personE.showInfo();

        bus100.showBusInfo();
        bus200.showBusInfo();

        subwayGreen.showBusInfo();
        goodTaxi.showInfo();
    }
}
