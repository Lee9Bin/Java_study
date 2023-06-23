package java_study.chapter2.ch08;

public class Subway {
    int subwayNumber;
    int personCnt;
    int income;

    public Subway(int subwayNumber){
        this.subwayNumber = subwayNumber;

    }
    public void take(int money){
        personCnt += 1;
        income += money;
    }

    public void showBusInfo(){
        System.out.println(subwayNumber + "번 버스의 승객은 " + personCnt + "명 이고, 수입은 " + income + "원 입니다");
    }
}
