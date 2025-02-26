package solved.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2011 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		sb.append(" ").append(br.readLine());
		String target = sb.toString();

		int[] dp = new int[target.length()];
		dp[0] = 1;
		dp[1] = 1;

		if (target.charAt(1) == '0') {
			System.out.println(0);
		} else {
			for (int i = 2; i < target.length(); i++) {
				char now = target.charAt(i);
				char pre = target.charAt(i - 1);

				if (now == '0') {
					if (pre == '1' || pre == '2') {
						dp[i] = dp[i - 2] % 1000000;
					} else {
						System.out.println(0);
						return;
					}
				} else {
					int num = (pre - '0') * 10 + (now - '0');
					if (10 <= num && num < 27) {
						dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000;
					} else {
						dp[i] = dp[i - 1] % 1000000;
					}
				}
			}
			System.out.println(dp[target.length() - 1] % 1000000);
		}
	}
}
