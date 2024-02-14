package solved.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class P16935 {
	static int n;
	static int m;
	static int r;
	static int[][] map;
	static Queue<Integer> que;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		que = new ArrayDeque<>();
		sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens()) {
			int oper = Integer.parseInt(st.nextToken());
			if (oper == 1) {
				operation1();
				saveTempMap(n, m);
			} else if (oper == 2) {
				operation2();
				saveTempMap(n, m);
			} else if (oper == 3) {
				operation3();
				saveTempMap(m, n);
			} else if (oper == 4) {
				operation4();
				saveTempMap(m, n);
			} else if (oper == 5) {
				operation5();
				saveTempMap(n, m);
			} else if (oper == 6) {
				operation6();
				saveTempMap(n, m);
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}

	public static void saveTempMap(int n, int m) {
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = que.poll();
			}
		}
		P16935.n = n;
		P16935.m = m;
	}

	public static void operation1() {
		for (int i = n - 1; i >= 0; i--) {
			for (int j = 0; j < m; j++) {
				que.add(map[i][j]);
			}
		}
	}

	public static void operation2() {
		for (int i = 0; i < n; i++) {
			for (int j = m - 1; j >= 0; j--) {
				que.add(map[i][j]);
			}
		}
	}

	public static void operation3() {
		for (int i = 0; i < m; i++) {
			for (int j = n - 1; j >= 0; j--) {
				que.add(map[j][i]);
			}
		}

	}

	public static void operation4() {

		for (int i = m-1; i >= 0; i--) {
			for (int j = 0; j < n; j++) {
				que.add(map[j][i]);
			}
		}

	}

	public static void operation5() {

		for (int i = n / 2; i < n; i++) {
			for (int j = 0; j < m / 2; j++) {
				que.add(map[i][j]);
			}
			for (int j = 0; j < m / 2; j++) {
				que.add(map[i - n / 2][j]);
			}
		}

		for (int i = n / 2; i < n; i++) {
			for (int j = m / 2; j < m; j++) {
				que.add(map[i][j]);
			}
			for (int j = m / 2; j < m; j++) {
				que.add(map[i - n / 2][j]);
			}
		}
	}

	public static void operation6() {

		for (int i = 0; i < n / 2; i++) {
			for (int j = m / 2; j < m; j++) {
				que.add(map[i][j]);
			}
			for (int j = m / 2; j < m; j++) {
				que.add(map[i + n / 2][j]);
			}
		}

		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < m / 2; j++) {
				que.add(map[i][j]);
			}
			for (int j = 0; j < m / 2; j++) {
				que.add(map[i + n / 2][j]);
			}
		}
	}
}
