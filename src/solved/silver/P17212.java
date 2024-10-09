package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P17212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            dp[i] = i;
            if (i >= 2) dp[i] = Math.min(dp[i], dp[i - 2] + 1);
            if (i >= 5) dp[i] = Math.min(dp[i], dp[i - 5] + 1);
            if (i >= 7) dp[i] = Math.min(dp[i], dp[i - 7] + 1);
        }

        System.out.println(dp[N]);

    }
}
