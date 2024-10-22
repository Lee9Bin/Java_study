package solved.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2660 {

	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

		for (int i = 0; i < n+1; i++) graph.add(new ArrayList<>());

		while (true){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (a == -1 && b == -1) break;

			graph.get(a).add(b);
			graph.get(b).add(a);
		}

		int[] students = new int[n+1];
		int result = Integer.MAX_VALUE;
		for (int i = 1; i < n+1; i++){
			students[i] = bfs(graph,i);
			result = Math.min(result, students[i]);
		}

		StringBuilder sb = new StringBuilder();
		int count = 0;

		for (int i = 1; i < n+1; i++){
			if (students[i] == result){
				count++;
			}
		}
		sb.append(result).append(" ").append(count).append("\n");
		for (int i = 1; i < n+1; i++){
			if (students[i] == result){
				sb.append(i).append(" ");
			}
		}
		System.out.println(sb);
	}

	public static int bfs(ArrayList<ArrayList<Integer>> graph, int target){
		int[] visited = new int[n+1];
		Arrays.fill(visited, Integer.MAX_VALUE);
		visited[target] = 0;

		ArrayDeque<int[]> deque = new ArrayDeque<>();
		deque.add(new int[] {target, 0});

		int maxDepth = 0;

		while (!deque.isEmpty()){
			int[] nowInfo = deque.pollFirst();
			int num = nowInfo[0];
			int count = nowInfo[1];

			for (int next : graph.get(num)){
				if (visited[next] > count + 1){
					visited[next] = count + 1;
					maxDepth = Math.max(maxDepth, count+1);
					deque.add(new int[] {next, count+1});
				}
			}
		}
		return maxDepth;
	}
}
