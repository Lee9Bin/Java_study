package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P17520 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		long[] dp = new long[100001];

		dp[1] = 2;
		dp[2] = 2;

		for (int i = 3; i < 100001; i+=2){
			dp[i] = dp[i-1] + dp[i-2] % 16769023;
			dp[i+1] = dp[i-1] + dp[i-2] % 16769023;
		}

		System.out.println(dp[N]  % 16769023);
	}
}
