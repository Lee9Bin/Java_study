package java_study.chapter6.ch08;

public class AutoCloseTest {
    public static void main(String[] args) {
        AutoCloseableObj obj = new AutoCloseableObj();

        try(obj) {
//          예외를 강제로 생성
            throw new Exception();
        }catch (Exception e){
            System.out.println("Exception");
        }
        System.out.println("종료");
    }
}
