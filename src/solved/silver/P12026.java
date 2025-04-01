package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P12026 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		char[] roads = br.readLine().toCharArray();
		int[] dp = new int[N];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;

		for (int i = 0; i < N; i++) {
			char now = roads[i];
			if (dp[i] == Integer.MAX_VALUE)
				continue;
			if (now == 'B') {
				for (int j = i + 1; j < N; j++) {
					if (roads[j] == 'O') {
						dp[j] = Math.min(dp[j], (j - i) * (j - i) + dp[i]);
					}
				}
			}
			if (now == 'O') {
				for (int j = i + 1; j < N; j++) {
					if (roads[j] == 'J')
						dp[j] = Math.min(dp[j], (j - i) * (j - i) + dp[i]);

				}

			}
			if (now == 'J') {
				for (int j = i + 1; j < N; j++) {
					if (roads[j] == 'B')
						dp[j] = Math.min(dp[j], (j - i) * (j - i) + dp[i]);
				}
			}
		}

		if (dp[N - 1] == Integer.MAX_VALUE)
			System.out.println(-1);
		else {
			System.out.println(dp[N - 1]);
		}
	}
}
