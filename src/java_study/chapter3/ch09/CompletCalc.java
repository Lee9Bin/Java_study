package java_study.chapter3.ch09;

//Calculator에서 만들지 않은 기능을 상속을 통해 구현
public class CompletCalc extends Calculator {
    @Override
    public int times(int num1, int num2) {
        return num1*num2;
    }

    @Override
    public int divide(int num1, int num2) {
        if (num2 == 0){
            return ERROR;
        }
        return num1/num2;
    }

    @Override
    public void description() {
        System.out.println("CompletCalc overriding");
    }

    public void showInfo(){
        System.out.println("모두 구현 됐습니다.");
    }
}
