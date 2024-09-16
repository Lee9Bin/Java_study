package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11969 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int[] cow = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            cow[i] = Integer.parseInt(br.readLine());
        }

        int[][] dp = new int[N + 1][3];
        for (int i = 1; i < N + 1; i++) {
            dp[i][0] += dp[i - 1][0];
            dp[i][1] += dp[i - 1][1];
            dp[i][2] += dp[i - 1][2];
            dp[i][cow[i] - 1] += 1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(dp[end][0] - dp[start - 1][0]).append(" ").append(dp[end][1] - dp[start - 1][1]).append(" ").append(dp[end][2] - dp[start - 1][2]).append("\n");
        }
        System.out.println(sb);
    }
}
