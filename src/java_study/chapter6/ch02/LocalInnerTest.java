package java_study.chapter6.ch02;

class Outer{

    int outNum = 100;
    static int sNum = 200;

    Runnable getRunnable(int i){
        int num = 100;

        class MyRunnable implements Runnable{

            int localNum = 10;

            @Override
            public void run() {
                //num = 200;   //에러 난다. 지역변수는 상수로 바뀜
                //i = 100;     //에러 난다. 매개 변수 역시 지역변수처럼 상수로 바뀜
                System.out.println("i =" + i);
                System.out.println("num = " +num);
                System.out.println("localNum = " +localNum);

                System.out.println("outNum = " + outNum + "(외부 클래스 인스턴스 변수)");
                System.out.println("Outter.sNum = " + Outer.sNum + "(외부 클래스 정적 변수)");
            }
        }
        return new MyRunnable();
    }

//   위에서 지역 내부클래스 이름을 지운것이 바로 익명 내부클래스!
//    Runnable getRunnable(int i){
//
//        int num = 100;
//
//        return new Runnable() {
//
//            @Override
//            public void run() {
//                //num = 200;   //에러 남
//                //i = 10;      //에러 남
//                System.out.println(i);
//                System.out.println(num);
//            }
//        };
//    }
//
//    Runnable runner = new Runnable() {
//
//        @Override
//        public void run() {
//            System.out.println("Runnable 이 구현된 익명 클래스 변수");
//
//        }
//    };

}

public class LocalInnerTest {

    public static void main(String[] args) {

        Outer out = new Outer();
        Runnable runner = out.getRunnable(10);
        runner.run();
    }
}
