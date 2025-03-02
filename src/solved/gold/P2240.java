package solved.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2240 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int[][][] dp = new int[T + 1][3][W + 1];

		int[][] plums = new int[T + 1][3];
		for (int i = 1; i < T + 1; i++) {
			int target = Integer.parseInt(br.readLine());
			plums[i][target] = 1;
		}

		for (int i = 1; i < T + 1; i++) {

			dp[i][1][0] = dp[i - 1][1][0] + plums[i][1];
			dp[i][2][0] = dp[i - 1][2][0] + plums[i][2];

			for (int j = 1; j < W + 1; j++) {
				dp[i][1][j] = Math.max(dp[i - 1][1][j] + plums[i][1], dp[i - 1][2][j - 1] + plums[i][1]);
				dp[i][2][j] = Math.max(dp[i - 1][2][j] + plums[i][2], dp[i - 1][1][j - 1] + plums[i][1]);
			}
		}

		int result = 0;
		for (int i = 0; i < W + 1; i++) {
			result = Math.max(dp[T][1][i], result);
			result = Math.max(dp[T][2][i], result);
		}

		System.out.println(result);

	}
}
