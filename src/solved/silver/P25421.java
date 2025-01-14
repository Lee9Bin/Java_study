package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P25421 {

    static final int mod = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[][] dp = new long[100001][10];

        for (int i = 1; i < 10; i++) dp[1][i] = 1;

        for (int i = 2; i < 100001; i++) {
            dp[i][1] = (dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3]) % mod;
            dp[i][2] = (dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3] + dp[i - 1][4]) % mod;
            dp[i][3] = (dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3] + dp[i - 1][4] + dp[i - 1][5]) % mod;
            dp[i][4] = (dp[i - 1][2] + dp[i - 1][3] + dp[i - 1][4] + dp[i - 1][5] + dp[i - 1][6]) % mod;
            dp[i][5] = (dp[i - 1][3] + dp[i - 1][4] + dp[i - 1][5] + dp[i - 1][6] + dp[i - 1][7]) % mod;
            dp[i][6] = (dp[i - 1][4] + dp[i - 1][5] + dp[i - 1][6] + dp[i - 1][7] + dp[i - 1][8]) % mod;
            dp[i][7] = (dp[i - 1][5] + dp[i - 1][6] + dp[i - 1][7] + dp[i - 1][8] + dp[i - 1][9]) % mod;
            dp[i][8] = (dp[i - 1][6] + dp[i - 1][7] + dp[i - 1][8] + dp[i - 1][9]) % mod;
            dp[i][9] = (dp[i - 1][7] + dp[i - 1][8] + dp[i - 1][9]) % mod;
        }

        int result = 0;
        for (int i = 1; i < 10; i++) {
            result += dp[n][i];
            result %= mod;
        }
        System.out.println(result);
    }
}
