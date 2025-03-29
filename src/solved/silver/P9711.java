package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class P9711 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		BigInteger[] dp = new BigInteger[10001];
		dp[1] = new BigInteger("1");
		dp[2] = new BigInteger("1");

		for (int i = 3; i < 10001; i++) {
			dp[i] = dp[i - 1].add(dp[i - 2]);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken());
			BigInteger Q = new BigInteger(st.nextToken());

			sb.append("Case #").append(i + 1).append(": ").append(dp[P].mod(Q)).append("\n");
		}
		System.out.println(sb);
	}
}
