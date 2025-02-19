package solved.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P21758 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N + 1];
		int[] dp = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 1; i < N + 1; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i < N + 1; i++) {
			dp[i] += nums[i] + dp[i - 1];
		}
		int result = 0;

		for (int i = 2; i < N; i++) {
			result = Math.max(result, 2 * (dp[N] - dp[i]) + dp[i - 1] - dp[1]);
			result = Math.max(result, 2 * (dp[i - 1] - dp[0]) + dp[N - 1] - dp[i]);
			result = Math.max(result, dp[i] - dp[1] + dp[N - 1] - dp[i - 1]);
		}
		System.out.println(result);
	}
}
