import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1303 {

	static final int[] dx = { -1, 0, 1, 0 };
	static final int[] dy = { 0, 1, 0, -1 };

	static int N, M;
	static long count;
	static char[][] map;
	static boolean[][] visited;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[M][N];

		for (int i = 0; i < M; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		visited = new boolean[M][N];
		long blue = 0;
		long white = 0;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					count = 1;
					visited[i][j] = true;
					dfs(i, j, map[i][j]);
					if (map[i][j] == 'B') blue += Math.pow(count, 2);
					else white += Math.pow(count, 2);
				}
			}
		}
		
		System.out.println(white + " " +blue);

	}

	public static void dfs(int x, int y, char target) {

		for (int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];

			if (0 <= nextX && nextX < M && 0 <= nextY && nextY < N && !visited[nextX][nextY] &&map[nextX][nextY] == target) {
				visited[nextX][nextY] = true;
				count++;
				dfs(nextX, nextY, target);
			}
		}
	}
}
