package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P10844 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[][] dp = new int[101][10];

		Arrays.fill(dp[1], 1);
		dp[1][0] = 0;

		for (int i = 1; i < 100; i++) {
			for (int j = 0; j < 10; j++) {
				if (dp[i][j] != 0) {
					if (j == 0) {
						dp[i + 1][1] += (dp[i][j] % 1000000000);
					} else if (j == 9) {
						dp[i + 1][8] += (dp[i][j] % 1000000000);
					} else {
						dp[i + 1][j - 1] += (dp[i][j] % 1000000000);
						dp[i + 1][j + 1] += (dp[i][j] % 1000000000);
					}
				}
			}
		}
		long total = 0;
		for (int a : dp[n]) {
			total += a;
		}
		System.out.println(total % 1000000000);
	}
}
