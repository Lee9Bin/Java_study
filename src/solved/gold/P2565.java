package solved.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class P2565 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ArrayList<int[]> lines = new ArrayList<>();

        lines.add(new int[]{0, 0});
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            lines.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        Collections.sort(lines, (int[] o1, int[] o2) -> {
            return o1[0] - o2[0];
        });

        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(dp[i], 1, n + 1, 1);
        }

        int reuslt = 1;
        for (int i = 1; i < n + 1; i++) {
            for (int j = i; j < n + 1; j++) {
                if (i < j && lines.get(i)[1] < lines.get(j)[1]) {
                    dp[i][j] = Math.max(dp[i - 1][i] + 1, dp[i - 1][j]);
                    reuslt = Math.max(reuslt, dp[i][j]);
                } else if (i < j && lines.get(i)[1] >= lines.get(j)[1]) {
                    dp[i][j] = dp[i - 1][j];

                }

            }
        }

        System.out.println(n - reuslt);

    }
}
