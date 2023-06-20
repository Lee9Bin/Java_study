package java_study.chapter2.ch04_Test;

public class HumanTest {
    public static void main(String[] args){

        Human saram1 = new Human();
        saram1.height = 180;
        saram1.weight = 78;
        saram1.zender = "남성";
        saram1.name = "Tomas";
        saram1.age = 37;

        saram1.getHumanInfo();
    }
}
