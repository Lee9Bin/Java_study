package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P9657 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[1001];
        Arrays.fill(dp, 1);
        dp[2] = 0;

        for (int i = 6; i < 1001; i++) {
            if (dp[i - 1] == 1 && dp[i - 3] == 1 && dp[i - 4] == 1) dp[i] = 0;
            else dp[i] = 1;
        }
        if (dp[N] == 1) System.out.println("SK");
        else System.out.println("CY");
    }
}
