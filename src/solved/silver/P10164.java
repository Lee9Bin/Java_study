package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10164 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int result = 0;

		if (K != 0) {
			int row = K / M;
			int col = K % M - 1;

			int first = combi(row + col, col);
			int second = combi(M - col - 1 + N - row - 1, N - row - 1);
			result = first * second;
		} else {
			result = combi(N + M - 2, N - 1);
		}

		System.out.println(result);
	}

	static int combi(int n, int r) {
		if (n == r || r == 0)
			return 1;
		return combi(n - 1, r - 1) + combi(n - 1, r);
	}
}
