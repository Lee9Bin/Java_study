package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P17271 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] dp = new int[10001];
		Arrays.fill(dp, 1);
		dp[M] += 1;

		for (int i = 1; i < N+1; i++){
			if (i - M >= 0){
				dp[i] = (dp[i-1] + dp[i-M]) % 1000000007;
			}
		}
		System.out.println(dp[N] % 1000000007 );
	}
}
