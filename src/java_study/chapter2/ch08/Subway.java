package java_study.chapter2.ch08;

public class Subway {
    int subwayNumber;
    int personCnt;
    int income;

    public Subway(int subwayNumber){
        this.subwayNumber = subwayNumber;

    }
    public void take(int income){
        personCnt += 1;
//      this = 매개변수와 멤버변수의 구분을 짖기 위해
        this.income += income;
    }

    public void showBusInfo(){
        System.out.println(subwayNumber + "번 버스의 승객은 " + personCnt + "명 이고, 수입은 " + income + "원 입니다");
    }
}
