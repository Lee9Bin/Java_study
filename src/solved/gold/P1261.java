import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1261 {

	static final int[] dx = { -1, 0, 1, 0 };
	static final int[] dy = { 0, 1, 0, -1 };

	static int[][] map;
	static boolean[][] visited;
	static int N, M;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N + 1][M + 1];
		visited = new boolean[N + 1][M + 1];

		for (int i = 1; i < N + 1; i++) {
			String s = br.readLine();
			for (int j = 1; j < M + 1; j++) {
				map[i][j] = s.charAt(j - 1) - '0';
			}
		}

		visited[1][1] = true;
		result = Integer.MAX_VALUE;
		bfs();
		System.out.println(result);
	}

	public static void bfs() {
		PriorityQueue<int[]> heap = new PriorityQueue<>((int[] o1, int[] o2) -> {
			return o1[0] - o2[0];
		});
		heap.add(new int[] { 1, 1 });
		int[][] visited = new int[N+1][M+1];
		for (int[] is : visited) {
			Arrays.fill(is, Integer.MAX_VALUE);
		}
		visited[1][1] = 0;
		while (!heap.isEmpty()) {
			int[] now = heap.poll();
			if (now[0] == N && now[1] == M) {
				result = visited[now[0]][now[1]];
			}

			for (int i = 0; i < 4; i++) {
				int nextX = now[0] + dx[i];
				int nextY = now[1] + dy[i];

				if (1 <= nextX && nextX <= N && 1 <= nextY && nextY <= M) {
					if (map[nextX][nextY] == 1) {
						if (visited[nextX][nextY] > visited[now[0]][now[1]] + 1) {
							visited[nextX][nextY] = visited[now[0]][now[1]] + 1;
							heap.add(new int[] {nextX, nextY});
							
						}
					} 
					else {
						if (visited[nextX][nextY] > visited[now[0]][now[1]]) {
							visited[nextX][nextY] = visited[now[0]][now[1]];
							heap.add(new int[] {nextX, nextY});
						} 
					}
				}
			}
		}

	}
}