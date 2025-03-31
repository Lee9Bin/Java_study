package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P21937 {

	static ArrayList<ArrayList<Integer>> graph;
	static boolean[] visited;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		graph = new ArrayList<>();
		for (int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(b).add(a);
		}

		int X = Integer.parseInt(br.readLine());
		visited = new boolean[N + 1];
		visited[X] = true;
		dfs(X);
		System.out.println(result);
	}

	public static void dfs(int target) {

		for (int next : graph.get(target)) {
			if (!visited[next]) {
				visited[next] = true;
				result++;
				dfs(next);
			}
		}
	}
}
