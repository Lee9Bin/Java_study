package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < N + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        int M = Integer.parseInt(br.readLine());
        int[] VIP = new int[M + 1];
        for (int i = 1; i < M + 1; i++) {
            VIP[i] = Integer.parseInt(br.readLine());
        }

        int result = 1;
        for (int i = 1; i < M + 1; i++) {
            int count = VIP[i] - VIP[i - 1] - 1;
            result *= dp[count];
        }

        result *= dp[N - VIP[M]];
        System.out.println(result);
    }
}
