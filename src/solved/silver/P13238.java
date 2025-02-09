package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P13238 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] coins = new int[N];
		for (int i = 0; i < N; i++) {
			coins[i] = Integer.parseInt(st.nextToken());
		}

		int now = coins[N - 1];
		int result = 0;
		for (int i = N - 1; i >= 0; i--) {
			if (now >= coins[i])
				result = Math.max(result, now - coins[i]);
			else {
				now = coins[i];
			}
		}
		System.out.println(result);
	}
}
