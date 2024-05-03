import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class P5567 {
	
	static int n,m;
	static ArrayList<ArrayList<Integer>> graph;
	static boolean[] visited;
	static Set<Integer> result;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		graph = new ArrayList<>();
		
		for (int i = 0; i < n+1; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		visited = new boolean[n+1];
		visited[1] = true;
		result = new HashSet<>();
		
		
		dfs(0, 1);
		System.out.println(result.size());
	}
	
	public static void dfs (int depth, int now) {
		if (0 < depth && depth <= 2) {
			result.add(now);
		}
		if (depth > 2) return;
		
		for (Integer next : graph.get(now)) {
			if (!visited[next]) {
				visited[next] = true;
				dfs(depth + 1, next);
				visited[next] = false;
			}
		}
	}
}
