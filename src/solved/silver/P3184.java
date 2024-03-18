package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class P3184 {

	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	static int R, C;
	static char[][] map;
	static boolean[][] visited;

	static int[] result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}

		result = new int[2];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (!visited[i][j] && map[i][j] != '#') {
					bfs(i, j);
				}
			}
		}
		System.out.println(result[0] + " " + result[1]);
	}

	public static void bfs(int x, int y) {
		int sheep = 0;
		int wolf = 0;

		Queue<int[]> que = new ArrayDeque<>();
		que.add(new int[] { x, y });
		visited[x][y] = true;
		if (map[x][y] == 'o') {
			sheep++;
		} else if (map[x][y] == 'v') {
			wolf++;
		}

		while (!que.isEmpty()) {
			int[] now = que.poll();

			for (int i = 0; i < 4; i++) {
				int nextX = now[0] + dx[i];
				int nextY = now[1] + dy[i];

				if (0 <= nextX && nextX < R && 0 <= nextY && nextY < C) {
					if (!visited[nextX][nextY] && map[nextX][nextY] != '#') {
						if (map[nextX][nextY] == 'o') {
							sheep++;
						} else if (map[nextX][nextY] == 'v') {
							wolf++;
						}
						visited[nextX][nextY] = true;
						que.add(new int[] { nextX, nextY });

					}
				}
			}
		}
		if (sheep > wolf) {
			result[0] += sheep;
		} else {
			result[1] += wolf;
		}

	}
}
