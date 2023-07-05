package solved.class2;

import java.util.Scanner;

public class p2292 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = 1;
        int cnt = 0;
        while (n > x){
            cnt +=1;
            x += 6*cnt;
        }
        System.out.println(cnt+1);
    }
}
