package solved.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P13398 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] nums = new int[N + 1];

		for (int i = 1; i < N + 1; i++)
			nums[i] = Integer.parseInt(st.nextToken());

		int[][] dp = new int[N + 1][2];
		dp[1][0] = nums[1];
		dp[1][1] = nums[1];

		int result = nums[1];
		for (int i = 2; i < N + 1; i++) {
			dp[i][0] = Math.max(dp[i - 1][0] + nums[i], nums[i]);
			dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1] + nums[i]);
			result = Math.max(dp[i][0], result);
			result = Math.max(dp[i][1], result);
		}

		System.out.println(result);

	}
}
