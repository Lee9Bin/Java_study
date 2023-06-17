package java_study.chapter1;

public class ForAndWhile {
    public static void main(String[] args){
        for (int i = 2; i < 10; i++){
            int cnt = 1;
            while (cnt <10){
                System.out.printf("%d * %d = %d",i,cnt,i*cnt);
                System.out.println();
                cnt ++;
            }
        }
        int cnt = 0;
        for (int i = 0; i< 1000; i++){
//            if (i == 2) {continue;}
            cnt +=1;
            if (cnt == 10){
                System.out.println(i);
                break;
            }
        }
        System.out.println(cnt);
    }
}
