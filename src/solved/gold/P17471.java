package solved.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P17471 {

	static int n;
	static int[] peoples;
	static int result;
	static int totalPeople;
	static boolean flag;
	static boolean[] visited;
	static ArrayList<ArrayList<int[]>> towns;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		peoples = new int[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());

		towns = new ArrayList<>();

		for (int i = 0; i < n + 1; i++) {
			towns.add(new ArrayList<>());
		}

		for (int i = 1; i < n + 1; i++) {
			peoples[i] = Integer.parseInt(st.nextToken());
			totalPeople += peoples[i];
		}

		for (int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			while (st.hasMoreTokens()) {
				int b = Integer.parseInt(st.nextToken());
				int c = peoples[b];
				towns.get(i).add(new int[] { b, c });
			}
		}

		visited = new boolean[n + 1];
		result = Integer.MAX_VALUE;
		dfs(1);
		if (flag)
			System.out.println(result);
		else
			System.out.println(-1);
	}

	public static void dfs(int cnt) {
		if (cnt == n + 1) {
			boolean[] visited1 = new boolean[n + 1];
			int start1 = 0;
			int start2 = 0;
			boolean[] visited2 = new boolean[n + 1];
			for (int i = 1; i < n + 1; i++) {
				if (visited[i]) {
					visited1[i] = true;
					start1 = i;
				} else {
					visited2[i] = true;
					start2 = i;
				}
			}
			if (start2 == 0)
				return;

			int a = isConect(start1, visited1);
			int b = isConect(start2, visited2);
			if (a + b == totalPeople) {
				flag = true;
				result = Math.min(result, Math.abs(a - b));
			}
			return;
		}

		for (int i = cnt; i < n + 1; i++) {
			visited[i] = true;
			dfs(i + 1);
			visited[i] = false;
		}
	}

	public static int isConect(int start, boolean[] visited) {
		Queue<Integer> que = new ArrayDeque<>();
		que.add(start);
		int total = 0;
		visited[start] = false;

		while (!que.isEmpty()) {
			int now = que.poll();
			total += peoples[now];

			for (int[] info : towns.get(now)) {
				if (visited[info[0]]) {
					visited[info[0]] = false;
					que.add(info[0]);
				}
			}
		}
		return total;
	}
}
