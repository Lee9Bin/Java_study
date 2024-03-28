package solved.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class P3055 {

	static final int[] dx = { -1, 0, 1, 0 };
	static final int[] dy = { 0, 1, 0, -1 };

	static char[][] map;
	static boolean[][] visited;
	static int R, C;

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
		BFS();

	}

	public static void BFS() {
		int beaberX = -1;
		int beaberY = -1;
		int targetX = -1;
		int targetY = -1;
		// 시간, x좌표, y좌표,
		Queue<int[]> que = new ArrayDeque<>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == '*') {
					que.add(new int[] { 0, '*', i, j });
				}
				if (map[i][j] == 'S') {
					beaberX = i;
					beaberY = j;
				}
				if (map[i][j] == 'D') {
					targetX = i;
					targetY = j;
				}
			}
		}
		map[beaberX][beaberY] = '.';

		visited[beaberX][beaberY] = true;
		que.add(new int[] { 0, 'S', beaberX, beaberY });
		int result = Integer.MAX_VALUE;

		while (!que.isEmpty()) {
			int[] info = que.poll();
			int time = info[0];
			int status = info[1];
			int x = info[2];
			int y = info[3];

			if (status == 'S' && x == targetX && y == targetY) {
				result = Math.min(result, time);
			}

			for (int i = 0; i < 4; i++) {
				int nextX = x + dx[i];
				int nextY = y + dy[i];
				if (0 <= nextX && nextX < R && 0 <= nextY && nextY < C) {
					if (status == 'S' && (map[nextX][nextY] == '.' || map[nextX][nextY] == 'D') && !visited[nextX][nextY]) {
						visited[nextX][nextY] = true;
						que.add(new int[] { time + 1, status, nextX, nextY });
					}

					if (status == '*' && map[nextX][nextY] == '.') {
						map[nextX][nextY] = '*';
						que.add(new int[] { time + 1, status, nextX, nextY });
					}

				}
			}
			if (map[x][y] == 'S')
				map[x][y] = '.';
		}

		if (result == Integer.MAX_VALUE) {
			System.out.println("KAKTUS");
		} else {
			System.out.println(result);
		}
	}
}
