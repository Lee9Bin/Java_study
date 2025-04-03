package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P17199 {

	static ArrayList<ArrayList<Integer>> graph;
	static boolean[] visited;
	static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		graph = new ArrayList<>();
		for (int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(b).add(a);
		}

		int result = -1;
		for (int i = 1; i < N + 1; i++) {
			visited = new boolean[N + 1];
			count = 0;
			dfs(i);
			if (count == N - 1)
				result = i;
		}
		System.out.println(result);
	}

	public static void dfs(int now) {
		for (int next : graph.get(now)) {
			if (!visited[next]) {
				visited[next] = true;
				count++;
				dfs(next);
			}
		}
	}
}
