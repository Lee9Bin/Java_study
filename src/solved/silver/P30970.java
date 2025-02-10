package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P30970 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[][] toys = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int Q = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			toys[i][0] = Q;
			toys[i][1] = P;
		}

		Arrays.sort(toys, (int[] o1, int[] o2) -> {
			return o2[0] != o1[0] ? o2[0] - o1[0] : o1[1] - o2[1];
		});
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 2; i++) {
			sb.append(toys[i][0]).append(" ").append(toys[i][1]);
			sb.append(" ");
		}

		sb.append("\n");

		Arrays.sort(toys, (int[] o1, int[] o2) -> {
			return o1[1] != o2[1] ? o1[1] - o2[1] : o2[0] - o1[0];
		});
		for (int i = 0; i < 2; i++) {
			sb.append(toys[i][0]).append(" ").append(toys[i][1]);
			sb.append(" ");
		}

		System.out.println(sb);
	}
}
