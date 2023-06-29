package java_study.chapter3.ch10;

public interface sell {
    void sell();

    default void order(){
        System.out.println("sell order");
    }
}
