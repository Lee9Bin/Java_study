package solved.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class P14499 {
	static int N, M, x, y, K;
	static int[][] map;
	static int[] dx = { 0, 0, 0, -1, 1 };
	static int[] dy = { 0, 1, -1, 0, 0 };
	static ArrayList<Integer> diceCul;
	static ArrayList<Integer> diceRow;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// for (int[] is : map) {
		// System.out.println(Arrays.toString(is));
		// }
		// System.out.println();
		diceCul = new ArrayList<>();
		diceRow = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			diceCul.add(0);
			diceRow.add(0);
		}

		// moveDice(1);

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			int dir = Integer.parseInt(st.nextToken());
			int nextX = x + dx[dir];
			int nextY = y + dy[dir];
			if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {
				moveDice(dir);
				if (map[nextX][nextY] == 0) {
					int down = diceCul.get(3);
					map[nextX][nextY] = down;
				} else {
					diceCul.remove(3);
					diceCul.add(map[nextX][nextY]);
					diceRow.remove(3);
					diceRow.add(map[nextX][nextY]);
					map[nextX][nextY] = 0;
				}
				System.out.println(diceCul.get(1));
				x = nextX;
				y = nextY;
			}

		}
	}

	static void moveDice(int dir) {
		if (dir == 1) {
			int down = diceRow.get(3); // 끝에거 확인
			diceRow.remove(3);// 끝에거 삭제
			diceRow.add(0, down);
			// Cul 맞추기
			int up = diceRow.get(1);
			diceCul.remove(1);
			diceCul.add(1, up);

			down = diceRow.get(3);
			diceCul.remove(3);
			diceCul.add(down);
		}
		if (dir == 2) {
			int down = diceRow.get(0); // 앞에거 확인
			diceRow.remove(0);// 앞에거 삭제
			diceRow.add(down);
			// Cul 맞추기
			int up = diceRow.get(1);
			diceCul.remove(1);
			diceCul.add(1, up);

			down = diceRow.get(3);
			diceCul.remove(3);
			diceCul.add(down);
		}

		if (dir == 3) {
			int first = diceCul.get(0);
			diceCul.remove(0);
			diceCul.add(first);

			int up = diceCul.get(1);
			diceRow.remove(1);
			diceRow.add(1, up);

			int down = diceCul.get(3);
			diceRow.remove(3);
			diceRow.add(down);
		}

		if (dir == 4) {
			int first = diceCul.get(3);
			diceCul.remove(3);
			diceCul.add(0, first);

			int up = diceCul.get(1);
			diceRow.remove(1);
			diceRow.add(1, up);

			int down = diceCul.get(3);
			diceRow.remove(3);
			diceRow.add(down);
		}
	}
}
