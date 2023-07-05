package solved.class2;

import java.util.Scanner;

public class p2231 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0;

        for (int i =1; i < n; i++){
            int num = i;
            int result = i;

            while (num != 0){
                result += num % 10;
                num = num/10;
            }

            if (result == n){
                cnt = i;
                break;
            }
        }
        System.out.println(cnt);
    }
}
