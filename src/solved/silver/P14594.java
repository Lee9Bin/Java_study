package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14594 {

	static int N;
	static int[][] rooms;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		rooms = new int[N+1][N+1];

		int M = Integer.parseInt(br.readLine());

		for (int i = 0; i < M; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			for (int j = a; j < b; j++){
				rooms[j][j+1] = 1;
				rooms[j+1][j] = 1;
			}

		}

		visited = new boolean[N+1];
		int result = 0;
		for (int i = 1; i < N+1; i++){
			if (!visited[i]) {
				result++;
				dfs(i);
			}
		}
		System.out.println(result);
	}
	public static void dfs(int now){

		for (int i = 1; i < N+1; i++){
			if (rooms[now][i] == 1 && !visited[i]){
				visited[i] = true;
				dfs(i);
			}
		}
	}
}
