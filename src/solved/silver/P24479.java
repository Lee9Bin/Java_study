package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class P24479 {
	
	static int N, M, R;
	static ArrayList<ArrayList<Integer>> graph;
	static int[] visited;
	static StringBuilder sb;
	static int index;

	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList<>();
		
		for (int i = 0; i < N+1; i++) graph.add(new ArrayList<>());
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());					
			int b = Integer.parseInt(st.nextToken());					
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		for (ArrayList<Integer> arrayList : graph) {
			Collections.sort(arrayList);
		}
		
		visited = new int[N+1];
		index = 1;
		dfs(R);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < N+1; i++) {
			sb.append(visited[i]).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void dfs(int now) {
		
		visited[now] = index;
		for (int next : graph.get(now)) {
			if (visited[next] == 0) {
				index += 1;
				dfs(next);
			}
		}
	}
}
