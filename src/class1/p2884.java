package class1;

import java.util.Scanner;

public class p2884 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int time = in.nextInt();
        int minute = in.nextInt();

        if(minute - 45 < 0){
            time -= 1;
            minute = 60 + (minute-45);
        } else {
            minute = minute - 45;

        }
        if (time < 0){
            time = 24 + time;
        }
        System.out.printf("%d %d",time,minute);
    }
}
