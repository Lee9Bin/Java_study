package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P9658 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[1001];
        dp[1] = 1;
        dp[3] = 1;

        for (int i = 4; i < 1001; i++) {
            if (dp[i - 1] != 1 && dp[i - 3] != 1 && dp[i - 4] != 1) {
                dp[i] = 1;
            }
        }
        if (dp[N] == 1) System.out.println("CY");
        else System.out.println("SK");
    }
}
