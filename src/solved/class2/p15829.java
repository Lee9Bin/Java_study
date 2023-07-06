package solved.class2;

import java.util.Arrays;
import java.util.Scanner;

public class p15829 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String arr = sc.next();
        long result = 0;
        long res = 1;

        for (int i = 0; i<n; i++){
            int charnum =(int)arr.charAt(i)-96;
            result += (charnum*res)%1234567891;
            res = (res*31)%1234567891;
        }
        System.out.println(result%1234567891);
    }
}
