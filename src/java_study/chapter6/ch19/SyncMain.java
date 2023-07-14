package java_study.chapter6.ch19;

class Lee extends Thread{
    public void run(){
        System.out.println("돈을 저축");
        SyncMain.mybank.saveMoney(3000);
        System.out.println("saveMoney(3000): "+SyncMain.mybank.getMoney());
    }
}

class Oh extends Thread{
    public void run(){
        System.out.println("돈을 사용");
        SyncMain.mybank.useMoney(2000);
        System.out.println("useMoney(2000): "+SyncMain.mybank.getMoney());
    }
}
public class SyncMain {
    public static Bank mybank = new Bank();

    public static void main(String[] args) {
        Lee l = new Lee();
        l.start();

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//
        Oh oh = new Oh();
        oh.start();
    }
}
