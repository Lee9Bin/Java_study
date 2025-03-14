package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14231 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] box = new int[n];
		for (int i = 0; i < n; i++) {
			box[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[n];
		dp[0] = 1;

		int reuslt = 1;
		for (int i = 1; i < n; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (box[i] > box[j]) {
					dp[i] = Math.max(dp[j] + 1, dp[i]);
				}
			}
		}
		for (int i : dp) {
			reuslt = Math.max(reuslt, i);
		}
		System.out.println(reuslt);

	}
}
