package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10164 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		long result = 0;

		if (K != 0) {
			int row = (K - 1) / M;
			int col = (K - 1) % M;

			long first = combi(row + col, col);
			long second = combi((N - 1 - row) + (M - 1 - col), N - 1 - row);
			result = first * second;
		} else {
			result = combi((N - 1) + (M - 1), N - 1);
		}

		System.out.println(result);
	}

	static long combi(int n, int r) {
		long[][] dp = new long[n + 1][r + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= Math.min(i, r); j++) {
				if (j == 0 || i == j) {
					dp[i][j] = 1;
				} else {
					dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
				}
			}
		}
		return dp[n][r];
	}
}
