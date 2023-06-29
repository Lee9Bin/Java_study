package java_study.chapter3.ch10;

public class BookShelfTest {
    public static void main(String[] args) {
        Queue que = new BookShelf();
        que.enQueue("규팔이 연대기1");
        que.enQueue("규팔이 연대기2");
        que.enQueue("규팔이 연대기3");
        que.enQueue("규팔이 연대기4");
        que.enQueue("규팔이 연대기5");

        System.out.println(que.getSize());

        for (int i = 0; i < 5 ; i++){
            System.out.println(que.deQueue());
        }
    }
}
