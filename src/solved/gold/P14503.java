package solved.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class P14503 {

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static int N, M;
	static int[][] map;
	static int x, y, dir;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		dir = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		bfs();

	}

	public static void bfs() {
		Queue<int[]> que = new ArrayDeque<>();

		que.add(new int[] { x, y });
		int result = 0;
		while (!que.isEmpty()) {
			int[] now = que.poll();
			int nowX = now[0];
			int nowY = now[1];
			boolean flag = false;

			if (map[nowX][nowY] == 0) {
				result++;
			}

			map[nowX][nowY] = 2; // 현재칸 청소

			for (int i = 0; i < 4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				if (map[nextX][nextY] == 0) {
					flag = true;
				}
			}

			// 주변 탐색후 0이 있는지 없는지 체크
			if (!flag) {
				int backDir = 0;
				if (dir == 0)
					backDir = 2;
				else if (dir == 1)
					backDir = 3;
				else if (dir == 2)
					backDir = 0;
				else if (dir == 3)
					backDir = 1;

				int nextX = nowX + dx[backDir];
				int nextY = nowY + dy[backDir];
				if (map[nextX][nextY] == 1)
					break;
				else if (map[nextX][nextY] == 0 || map[nextX][nextY] == 2) {
					que.add(new int[] { nextX, nextY });
				}
			} else if (flag) {
				while (true) {
					dir -= 1;
					if (dir == -1) {
						dir = 3;
					}
					int nextX = nowX + dx[dir];
					int nextY = nowY + dy[dir];
					if (map[nextX][nextY] == 0) {
						que.add(new int[] { nextX, nextY });
						break;
					}
				}
			}
		}
		System.out.println(result);
	}
}
