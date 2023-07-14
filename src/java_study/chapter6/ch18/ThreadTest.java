package java_study.chapter6.ch18;
public class ThreadTest {
    public static void main(String[] args) {
////      쓰레드 우선순위 부여
//        PriorityThread pt1 = new PriorityThread();
//        PriorityThread pt2 = new PriorityThread();
//        PriorityThread pt3 = new PriorityThread();
//        pt1.setPriority(Thread.MIN_PRIORITY);
//        pt2.setPriority(Thread.NORM_PRIORITY);
//        pt3.setPriority(Thread.MAX_PRIORITY);
//
//        pt1.start();
//        pt2.start();
//        pt3.start();

        JoinThread jt1 = new JoinThread(1,50);
        JoinThread jt2 = new JoinThread(51,100);

        jt1.start();
        jt2.start();
//      메인 쓰레드가 시작되면서 jt1과 jt2를 시작하고 lastTotal에 값을 담을때 jt1과 jt2값이 수행이 안끝났을수도 있고 끝났을수도 있고 값이 달라져
//      그래서 join을 걸어서 메인쓰레드가 runnable 상태에 들어가 얘들이 수행이 끝날때까지 기다려

        try {
            jt1.join();
            jt2.join();
        } catch (InterruptedException e) {
//      예외발생시 해당쓰레드 종료
            jt1.interrupt();
            jt2.interrupt();
        }
        int lastTotal = jt1.total + jt2.total;

        System.out.println("jt1.total = " + jt1.total);
        System.out.println("jt2.total = " + jt2.total);
        System.out.println("lastTotal = " + lastTotal);

    }

}
