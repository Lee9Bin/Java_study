package solved.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P15681 {

	static int[] dp;
	static boolean[] visited;
	static ArrayList<Integer>[] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N + 1];
		for (int i = 1; i < N + 1; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);

		}

		dp = new int[N + 1];
		visited = new boolean[N + 1];
		dfs(R);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < Q; i++) {
			int target = Integer.parseInt(br.readLine());
			sb.append(dp[target]).append("\n");
		}
		System.out.println(sb);
	}

	public static int dfs(int num) {
		visited[num] = true;
		dp[num] = 1;

		for (int next : graph[num]) {
			if (!visited[next]) {
				dp[num] += dfs(next);
			}
		}
		return dp[num];
	}
}
