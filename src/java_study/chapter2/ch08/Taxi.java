package java_study.chapter2.ch08;

public class Taxi {
    String taxiName;
    int income;

    public Taxi(String taxiName){
        this.taxiName = taxiName;
    }

    public void take(int money){
        income += money;
    }

    public void showInfo(){
        System.out.println(taxiName + " 수입은 " + income +"원 입니다.");
    }
}
