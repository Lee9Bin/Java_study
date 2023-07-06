package java_study.chapter5.ch01_2;

public class Plastic extends Material{
    public String toString(){
        return "재료는 Plastic 입니다";
    }

    @Override
    public void doPrintng() {
        System.out.println("Plastic의 재료를 가지고 프린팅중입니다.");
    }
}
