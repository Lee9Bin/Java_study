package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P8394 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long[] dp = new long[10000001];
		dp[1] = 1;
		dp[2] = 2;

		for (int i = 3; i < 10000001; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % 10;
		}

		System.out.println(dp[Integer.parseInt(br.readLine())]);

	}
}
