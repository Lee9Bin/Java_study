package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11060 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;
        boolean[] possible = new boolean[N+1];
        possible[1] = true;
        for (int i = 1; i < N + 1; i++) {
            if (possible[i]){
                int now = Integer.parseInt(st.nextToken());
                for (int j = 1; j <= now; j++) {
                    if (i + j <= N) {
                        dp[i + j] = Math.min(dp[i] + 1, dp[i + j]);
                        possible[i+j] = true;
                    }
                }
            }
        }

        if (dp[N] == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(dp[N]);
    }
}
