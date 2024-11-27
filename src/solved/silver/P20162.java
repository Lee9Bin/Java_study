package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P20162 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] snack = new int[n];

        for (int i = 0; i < n; i++) {
            snack[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[n];
        int result = 0;

        for (int i = 0; i < n; i++) {
            dp[i] = snack[i];
            for (int j = 0; j < i; j++) {
                if (snack[j] < snack[i]) {
                    dp[i] = Math.max(dp[j] + snack[i], dp[i]);
                }
            }
            result = Math.max(result, dp[i]);
        }
        System.out.println(result);
    }
}
