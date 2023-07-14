package java_study.chapter6.ch16;

public class CoffeeTest {
    public static void main(String[] args) {
        Coffee etiopia = new EtiopiaAmericano();
        etiopia.brewing();

        System.out.println();
        Coffee etiopiamilk = new Latte(new EtiopiaAmericano());
        etiopiamilk.brewing();
    }
}
