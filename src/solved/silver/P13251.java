package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P13251 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] count = new int[N];

		int total = 0;
		for (int i = 0; i < N; i++) {
			count[i] = Integer.parseInt(st.nextToken());
			total += count[i];
		}

		int K = Integer.parseInt(br.readLine());
		double[] dp = new double[N];
		double result = 0;

		for (int i = 0; i < N; i++) {
			if (count[i] >= K) {
				dp[i] = 1;

				for (int j = 0; j < K; j++) {
					dp[i] *= (double)(count[i] - j) / (total - j);
				}
			}
			result += dp[i];
		}

		System.out.println(result);
	}
}
