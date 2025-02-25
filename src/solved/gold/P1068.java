package solved.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P1068 {

	static ArrayList<ArrayList<Integer>> graph;
	static boolean[] visited;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		graph = new ArrayList<>();
		for (int i = 0; i < N; i++)
			graph.add(new ArrayList<>());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] info = new int[N];
		for (int i = 0; i < N; i++) {
			int target = Integer.parseInt(st.nextToken());
			info[i] = target;
			if (target == -1)
				continue;
			graph.get(target).add(i);
		}

		int no = Integer.parseInt(br.readLine());

		visited = new boolean[N];

		visited[no] = true;
		dfs(no, false);

		for (int i = 0; i < N; i++) {
			if (!visited[i] && info[i] == -1) {
				visited[i] = true;
				dfs(i, true);
			}
		}
		System.out.println(result);
	}

	public static void dfs(int now, boolean check) {

		int count = 0;
		for (int next : graph.get(now)) {
			if (!visited[next]) {
				visited[next] = true;
				count++;
				dfs(next, check);
			}

		}
		if (count == 0 && check) {
			result++;
		}
	}
}
