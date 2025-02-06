package solved.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P14267 {

	static ArrayList<ArrayList<Integer>> graph;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		graph = new ArrayList<>();
		for (int i = 0; i < n + 1; i++) {
			graph.add(new ArrayList<>());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < n + 1; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (num == -1)
				continue;
			graph.get(num).add(i);
		}

		dp = new int[n + 1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			dp[num] += w;
		}

		dfs(1);
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < n + 1; i++) {
			sb.append(dp[i]).append(" ");
		}
		System.out.println(sb);
	}

	public static void dfs(int target) {
		for (int next : graph.get(target)) {
			dp[next] += dp[target];
			dfs(next);
		}
	}
}
