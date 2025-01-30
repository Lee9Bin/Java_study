package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P14606 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[11];
        dp[2] = 1;

        for (int i = 3; i < 11; i++) {
            dp[i] = (i - 1) + dp[i - 1];
        }

        System.out.println(dp[n]);
    }
}
