package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P15735 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long[] arr = new long[10001];

		for (int i = 1; i < 10001; i++) {
			arr[i] = arr[i - 1] + i;
		}

		int N = Integer.parseInt(br.readLine());
		long ans = 0;

		for (int i = 1; i <= N; i++) {
			ans += arr[i];
		}

		for (int i = N - 1; i > 0; i -= 2) {
			ans += arr[i];
		}

		System.out.println(ans);
	}
}
