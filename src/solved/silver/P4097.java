package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P4097 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		while (true) {
			int N = Integer.parseInt(br.readLine());
			if (N == 0)
				break;

			long[] cost = new long[N];
			long[] dp = new long[N];

			for (int i = 0; i < N; i++) {
				cost[i] = Integer.parseInt(br.readLine());
			}
			dp[0] = cost[0];

			for (int i = 1; i < N; i++) {
				dp[i] = Math.max(cost[i], cost[i] + dp[i - 1]);
			}

			long result = Long.MIN_VALUE;
			for (long target : dp) {
				result = Math.max(target, result);
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
}
