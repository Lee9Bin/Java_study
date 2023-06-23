package java_study.chapter2.ch08;

public class Taxi {
    String taxiName;
    int income;

    public Taxi(String taxiName){
        this.taxiName = taxiName;
    }

    public void take(int money){
//      이렇게 매개변수와 멤버변수의 변수명이 다르다면 이렇게 써도 돼
//      하지만 코드의 가독성 부분이 떨어질 수도 있고 일관성에도 문제가 될 수 있어

        income += money;
    }

    public void showInfo(){
        System.out.println(taxiName + " 수입은 " + income +"원 입니다.");
    }
}
