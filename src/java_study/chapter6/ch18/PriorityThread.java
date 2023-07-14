package java_study.chapter6.ch18;

class PriorityThread extends Thread{
    public void run(){
        int sum = 0;
        Thread t = Thread.currentThread();
        System.out.println( t + "start");

        for(int i =0; i<=1000000; i++){
            sum += i;
        }
        System.out.println( t.getPriority() + "end");
    }
}