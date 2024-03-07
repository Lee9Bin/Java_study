package solved.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P17406 {

	static int N, M, K, result;
	static int[][] map;
	static int[][] subMap;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static ArrayList<int[]> cord;
	static int[] order;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N + 1][M + 1];
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < M + 1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		cord = new ArrayList<>();
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			cord.add(new int[] { r, c, s });
		}
		order = new int[cord.size()];
		visited = new boolean[cord.size()];

		result = Integer.MAX_VALUE;
		permutiation(0);

		System.out.println(result);
	}

	public static void permutiation(int cnt) {
		if (cnt == cord.size()) {
			subMap = new int[N + 1][M + 1];

			for (int i = 1; i < N + 1; i++) {
				for (int j = 1; j < M + 1; j++) {
					subMap[i][j] = map[i][j];
				}
			}

			for (int i : order) {
				int[] now = cord.get(i);
				rotation(now[0], now[1], now[2]);
			}

			for (int i = 1; i < N + 1; i++) {
				int total = 0;
				for (int j = 1; j < M + 1; j++) {
					total += subMap[i][j];
				}
				result = Math.min(result, total);
			}

			return;
		}
		for (int i = 0; i < cord.size(); i++) {
			if (!visited[i]) {
				order[cnt] = i;
				visited[i] = true;
				permutiation(cnt + 1);
				visited[i] = false;
			}
		}
	}

	public static void rotation(int r, int c, int s) {
		int size = (2 * s + 1) * (2 * s + 1);
		int[] temp = new int[size];

		int nowX = r - s;
		int nowY = c - s;
		int index = 0;
		boolean[][] visited = new boolean[N + 1][M + 1];
		for (int i = 0; i < size; i++) {
			temp[i] = subMap[nowX][nowY];
			visited[nowX][nowY] = true;
			int nextX = nowX + dx[index % 4];
			int nextY = nowY + dy[index % 4];

			if (nextX < r - s || r + s < nextX || nextY < c - s || c + s < nextY || visited[nextX][nextY]) {
				index++;
			}
			nowX = nowX + dx[index % 4];
			nowY = nowY + dy[index % 4];
		}

		nowX = r - s;
		nowY = c - s + 1;
		index = 0;
		int cnt = 0;
		visited = new boolean[N + 1][M + 1];
		for (int i = 0; i < size - 1; i++) {
			subMap[nowX][nowY] = temp[i];
			visited[nowX][nowY] = true;
			if (nowX == r - s + cnt && nowY == c - s + cnt) {
				nowX += 1;
				nowY += 2;
				cnt += 1;
				continue;
			}
			int nextX = nowX + dx[index % 4];
			int nextY = nowY + dy[index % 4];
			if (nextX < r - s || r + s < nextX || nextY < c - s || c + s < nextY || visited[nextX][nextY]) {
				index++;
			}
			nowX = nowX + dx[index % 4];
			nowY = nowY + dy[index % 4];
		}
	}
}
