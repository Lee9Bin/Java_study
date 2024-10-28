package solved.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P16987 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < N+1; i++)graph.add(new ArrayList<>());

		int[] visited = new int[N+1];
		for (int i = 0; i < M; i++){
			st= new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			visited[b] += 1;
		}
		ArrayDeque<int[]> deque = new ArrayDeque<>();

		int[] result = new int[N+1];
		for (int i = 1; i < N+1; i++) {
			if (visited[i] == 0) deque.add(new int[] {i, 1});
		}

		while (!deque.isEmpty()){
			int[] now = deque.pollFirst();
			int target = now[0];
			int count = now[1];

			result[target] = count;

			for (int next : graph.get(target)){
				visited[next] -= 1;
				if (visited[next] == 0) deque.add(new int[] {next, count+1});
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < N+1; i++) {
			sb.append(result[i]).append(" ");
		}
		System.out.println(sb);
	}
}
