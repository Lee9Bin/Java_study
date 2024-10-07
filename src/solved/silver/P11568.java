package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] nums = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n + 1][n + 1];

        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(dp[i], 1, n + 1, 1);
        }

        int reuslt = 1;
        for (int i = 1; i < n + 1; i++) {
            for (int j = i; j < n + 1; j++) {
                if (i < j && nums[i] < nums[j]) {
                    dp[i][j] = Math.max(dp[i - 1][i] + 1, dp[i - 1][j]);
                    reuslt = Math.max(reuslt, dp[i][j]);
                } else if (i < j && nums[i] >= nums[j]) {
                    dp[i][j] = dp[i - 1][j];

                }

            }
        }

        System.out.println(reuslt);
    }
}
