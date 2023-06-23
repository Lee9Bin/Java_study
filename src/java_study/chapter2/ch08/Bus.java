package java_study.chapter2.ch08;

public class Bus {
    int busNumber;
    int personCnt;
    int income;

    public Bus(int busNumber){
        this.busNumber = busNumber;

    }
    public void take(int money){
        personCnt += 1;
//        income += money;
        this.income += money;
    }

    public void showBusInfo(){
        System.out.println(busNumber + "번 버스의 승객은 " + personCnt + "명 이고, 수입은 " + income + "원 입니다");
    }

}
