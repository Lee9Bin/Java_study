package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P16493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] dp = new int[M + 1][N + 1];

        int[][] chapters = new int[M + 1][2];
        for (int i = 1; i < M + 1; i++) {
            st = new StringTokenizer(br.readLine());
            chapters[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }

        //[0] day, [1] pages
        for (int i = 1; i < M + 1; i++) {
            for (int j = 0; j < N + 1; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - chapters[i][0] >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j - chapters[i][0]] + chapters[i][1], dp[i - 1][j]);
                }
            }
        }
        System.out.println(dp[M][N]);
    }
}
