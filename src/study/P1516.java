package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1516 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		int[] degree = new int[n + 1];
		int[] times = new int[n + 1];

		for (int i = 0; i < n + 1; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			times[i + 1] = time;
			while (st.hasMoreTokens()) {
				int target = Integer.parseInt(st.nextToken());
				if (target == -1)
					break;
				graph.get(target).add(i + 1);
				degree[i + 1]++;

			}

		}

		Queue<Integer> que = new ArrayDeque<>();
		int[] dp = new int[n + 1];
		// Arrays.fill(dp, Integer.MAX_VALUE);
		for (int i = 1; i < n + 1; i++) {
			if (degree[i] == 0) {
				que.add(i);
				dp[i] = times[i];
			}
		}

		// System.out.println(Arrays.toString(dp));
		while (!que.isEmpty()) {
			int nowNum = que.poll();
			// System.out.println(nowNum);

			for (int next : graph.get(nowNum)) {
				degree[next]--;
				dp[next] = Math.max(dp[next], dp[nowNum]);
				if (degree[next] == 0) {
					dp[next] += times[next];
					que.add(next);
				}
			}
		}

		// System.out.println(Arrays.toString(dp));
		// System.out.println(Arrays.toString(times));
		for (int i = 1; i < n + 1; i++) {
			System.out.println(dp[i]);
		}

	}
}
