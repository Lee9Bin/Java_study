package java_study.chapter3.ch09;


//인터페이스 구현 한다 implements
public abstract class Calculator implements Calc {
//인터페이스에서 요구한 기능을 다 포함하지 않기 떄문에 abstract가 돼야 해
    @Override
    public int add(int num1, int num2) {
        return num1 + num2;
    }

    @Override
    public int substract(int num1, int num2) {
        return num1 - num2;
        }

}
