package solved.silver;

import java.math.BigInteger;
import java.util.Scanner;

public class p1010 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            BigInteger result = BigInteger.ONE;
            BigInteger div = BigInteger.ONE;
            if (n == 0){
                result = BigInteger.ZERO;
            }
            for (int j = n; j > 0; j--){
                result = result.multiply(BigInteger.valueOf(m));
                div = div.multiply(BigInteger.valueOf(j));
                m -= 1;
            }
            System.out.println(result.divide(div));
        }
    }
}
