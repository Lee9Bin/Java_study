package java_study.chapter6.ch18;

public class JoinThread extends Thread{
    int start;
    int end;
    int total;
    public JoinThread(int start, int end){
        this.start = start;
        this.end = end;
    }
    public void run(){
        int i ;
        for (i = start; i<=end; i++){
            total+=i;
        }
    }

}
