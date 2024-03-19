package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1965 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] nums = new int[n + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < n + 1; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[n + 1];

		Arrays.fill(dp, 1, n + 1, 1);
		int result = 1;
		for (int i = 1; i < n + 1; i++) {
			for (int j = i; j < n + 1; j++) {
				if (i < j && nums[i] < nums[j]) {
					dp[j] = Math.max(dp[i] + 1, dp[j]);
				}
				result = Math.max(result, dp[j]);
			}

		}
		System.out.println(result);
	}
}
