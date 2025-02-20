package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11059 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] num = br.readLine().toCharArray();
		int[] dp = new int[num.length + 1];
		dp[1] = num[0] - '0';

		for (int i = 2; i < num.length + 1; i++) {
			dp[i] += dp[i - 1] + (num[i - 1] - '0');
		}

		int result = 0;
		for (int i = 1; i < dp.length; i++) {
			for (int j = i; j < dp.length; j++) {
				int len = (j - i + 1);
				if (len % 2 == 0) {
					if (dp[i + len / 2 - 1] - dp[i - 1] == dp[j] - dp[i + len / 2 - 1])
						result = Math.max(result, len);
				}
			}
		}

		System.out.println(result);

	}
}
