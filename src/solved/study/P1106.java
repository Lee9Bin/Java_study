package solved.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1106 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] dp = new int[C+101]; // 인원
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());
            for (int j = cnt; j < C+101; j++){
                if (dp[j-cnt] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j-cnt] + cost);
                }
            }

            // System.out.println(Arrays.toString(dp));
        }
        int result = Integer.MAX_VALUE;

        for (int i = C; i < C+101; i++){
            result = Math.min(result, dp[i]);
        }
        System.out.println(result);
    }
}
