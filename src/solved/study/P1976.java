import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1976 {
	
	static int n,m,cnt;
	static int[][] graph;
	static int[] target;
	static boolean[] visited;
	static boolean flag;
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		graph = new int[n+1][n+1];
		visited = new boolean[n+1];
		target = new int[m];
		
		for (int i = 1; i < n+1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j < n+1; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			target[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < m-1; i++) {
			visited = new boolean[n+1];
			flag = false;
			dfs(target[i], target[i+1]);
			if (!flag) break;
		}
//		System.out.println(cnt);
		if (cnt == m-1) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
	}
	
	public static void dfs(int start, int end) {
		if (start == end) {
			flag = true;
			cnt ++;
			return;
		}
		
		for (int i = 1; i < n+1; i++) {
			if (graph[start][i] == 1 && !visited[i]) {
				visited[i] = true;
				dfs(i, end);
			}
		}
	}
}
