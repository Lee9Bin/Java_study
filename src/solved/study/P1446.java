package solved.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1446 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());

		PriorityQueue<int[]> roads = new PriorityQueue<>((int[] o1, int[] o2) -> {
			return o1[0] != o2[0] ? o1[0] - o2[0]
					: (o1[1] != o2[1] ? o1[1] - o2[1] : o1[2] - o2[2]);
		});
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			roads.add(new int[] { Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });
		}

		int[] dp = new int[10001];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		while (!roads.isEmpty()) {
			int[] now = roads.peek();
			if (now[0] != 0) {
				break;
			}
			now = roads.poll();
			dp[now[1]] = Math.min(dp[now[1]], dp[now[0]] + now[2]);
		}

		for (int i = 1; i < 10001; i++) {
			dp[i] = Math.min(dp[i - 1] + 1, dp[i]);
			while (!roads.isEmpty()) {
				int[] now = roads.peek();
				if (now[0] != i) {
					break;
				}
				now = roads.poll();
				dp[now[1]] = Math.min(dp[now[1]], dp[now[0]] + now[2]);
			}
		}

		// System.out.println(Arrays.toString(dp));
		System.out.println(dp[D]);
	}
}
