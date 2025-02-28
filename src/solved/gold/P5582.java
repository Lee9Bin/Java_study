package solved.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P5582 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] first = br.readLine().toCharArray();
		char[] second = br.readLine().toCharArray();
		int[][] dp = new int[first.length + 1][second.length + 1];

		int result = 0;
		for (int i = 1; i < first.length + 1; i++) {
			for (int j = 1; j < second.length + 1; j++) {
				if (first[i - 1] == second[j - 1])
					dp[i][j] = dp[i - 1][j - 1] + 1;
				result = Math.max(result, dp[i][j]);
			}
		}

		System.out.println(result);
	}
}
