package java_study.chapter6.ch19;

public class Bank {
//  Bank가 공통자원

    private int money = 10000;
//  동시에 수행이 되면 안되는 함수들에 synchronized 선언해서 동기화 시키기
//  해당 메소드가 속해있는 객체에 락을 거는거야
    public synchronized void saveMoney(int save){
        int m = getMoney();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        setMoney(m+save);
    }

//  synchronized 블록방식
    public void useMoney(int use){
        synchronized (this){
            int m = getMoney();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            setMoney(m-use);
        }
    }
    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
