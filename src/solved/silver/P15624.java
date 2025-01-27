package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P15624 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[] dp = new long[1000001];
        dp[1] = 1;

        for (int i = 2; i < 1000001; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }

        System.out.println(dp[n] % 1000000007);
    }
}
