package solved.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P15989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int[] dp = new int[10001];
        Arrays.fill(dp,1);
        for (int i = 2; i < 10001; i ++){
            dp[i] += dp[i-2];
        }
        for (int i = 3; i < 10001; i ++){
            dp[i] += dp[i-3];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++){
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append("\n");
        }
        System.out.println(sb);
    }
}
