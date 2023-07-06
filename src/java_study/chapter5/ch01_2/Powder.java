package java_study.chapter5.ch04_2;

public class Powder extends Material{
    public String toString(){
        return "재료는 Powder 입니다";
    }

    @Override
    public void doPrintng() {
        System.out.println("Powder 재료를 가지고 프린팅중입니다.");

    }
}
