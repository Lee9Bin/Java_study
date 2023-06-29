package java_study.chapter3.ch10;

public interface buy {
    void buy();
    default void order(){
        System.out.println("buy order");
    }

}
