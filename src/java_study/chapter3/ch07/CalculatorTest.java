package java_study.chapter3.ch07;

public class CalculatorTest {
    public static void main(String[] args){
        int num1 = 10;
        int num2 = 2;
        Calc calc = new CompletCalc();
        System.out.println(calc.add(num1,num2));
        System.out.println(calc.substract(num1,num2));
        System.out.println(calc.times(num1,num2));
        System.out.println(calc.divide(num1,num2));
    }
}
