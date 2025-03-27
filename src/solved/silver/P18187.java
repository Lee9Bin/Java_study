package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P18187 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] dp = new int[101];

		dp[1] = 2;
		dp[2] = 4;
		dp[3] = 7;

		int now = 3;

		for (int i = 4; i < 101; i++) {
			dp[i] = dp[i - 1] + now;
			if (i % 3 != 0)
				now++;
		}

		System.out.println(dp[N]);
	}
}
