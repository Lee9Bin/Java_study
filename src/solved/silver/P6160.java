package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P6160 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] cows = new int[N][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			cows[i] = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i};
		}

		Arrays.sort(cows, (int[] o1, int[] o2) -> {
			return o2[0] - o1[0];
		});
		int[][] result = new int[K][3];
		for (int i = 0; i < K; i++) {
			result[i] = cows[i];
		}
		Arrays.sort(result, (int[] o1, int[] o2) -> {
			return o2[1] - o1[1];
		});
		System.out.println(result[0][2] + 1);
	}
}
