package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P2688 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long[][] dp = new long[65][10];
		Arrays.fill(dp[1], 1);

		for (int i = 2; i < 65; i++) {

			for (int j = 0; j < 10; j++) {
				if (dp[i - 1][j] > 0) {
					for (int k = j; k < 10; k++) {
						dp[i][k] += dp[i - 1][j];
					}
				}
			}
		}

		long[] result = new long[65];
		for (int i = 1; i < 65; i++) {
			for (int j = 0; j < 10; j++) {
				result[i] += dp[i][j];
			}
		}

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			sb.append(result[Integer.parseInt(br.readLine())]).append("\n");
		}

		System.out.println(sb);
	}
}
