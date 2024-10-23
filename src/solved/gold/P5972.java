package solved.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P5972 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
		for (int i = 0; i < N+1; i++){
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph.get(a).add(new int[] {b, c});
			graph.get(b).add(new int[] {a, c});
		}

		int[] visited = new int[N+1];
		Arrays.fill(visited, Integer.MAX_VALUE);
		visited[1] = 0;

		PriorityQueue<int[]> heapq = new PriorityQueue<>((int[] o1, int[] o2) -> {
			return o1[1] - o2[1];
		});
		heapq.add(new int[] {1, 0});

		while (!heapq.isEmpty()){
			int[] nowInfo = heapq.poll();
			int target = nowInfo[0];
			int cost = nowInfo[1];

			if (target == N){
				break;
			}

			for (int[] next : graph.get(target)){
				int nextTarget = next[0];
				int nextCost = next[1];
				if (cost + nextCost < visited[nextTarget]){
					visited[nextTarget] = cost + nextCost;
					heapq.add(new int[] {nextTarget, cost + nextCost});
				}
			}
		}

		System.out.println(visited[N]);
	}
}
