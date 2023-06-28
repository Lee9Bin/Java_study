package java_study.chapter3.ch05;

public class Desktop extends Computer{

    @Override
    public void display() {
        System.out.println("Desktop display");
    }

    @Override
    public void typing() {
        System.out.println("Desktop typing");
    }
}
