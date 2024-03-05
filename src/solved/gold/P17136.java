package solved.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P17136 {

	static int result, totalPapers;
	static boolean flag;
	static int[][] map;
	static int[] papers;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		map = new int[10][10];
		visited = new boolean[10][10];
		papers = new int[] { 0, 5, 5, 5, 5, 5 };
		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					totalPapers++;
			}
		} // 입력 받은 값 맵에 저장

		result = Integer.MAX_VALUE;
		flag = false;
		attachPaper(0, 0);
		if (flag)
			System.out.println(result);
		else
			System.out.println(-1);
	}

	public static boolean makePaper(int x, int y, int n, boolean check) {
		if (check == true) {
			for (int i = x; i < x + n; i++) {
				for (int j = y; j < y + n; j++) {
					if (i >= 10 || j >= 10)
						return false; // 범위 벗어남
					if (map[i][j] != 1 || visited[i][j])
						return false;
				}
			}
		}

		for (int i = x; i < x + n; i++) {
			for (int j = y; j < y + n; j++) {
				if (map[i][j] == 1)
					visited[i][j] = check;
			}
		}
		// 문제 없었다면
		return true;
	}

	public static void attachPaper(int cnt, int paperCnt) {
		if (cnt > result)
			return;
		if (paperCnt == totalPapers) {
			getResult(cnt);
			return;
		}

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					for (int k = 1; k < 6; k++) {
						if (papers[k] > 0 && makePaper(i, j, k, true)) {
							papers[k] -= 1;
							attachPaper(cnt + 1, paperCnt + k * k);
							papers[k] += 1;
							makePaper(i, j, k, false);
						}
					}
					return; // 0, 0 으로 돌아가기 때문에 1~5사이즈 크기 다봤으면 종료
				}
			}
		}
	}

	public static void getResult(int cnt) {
		flag = true;
		result = Math.min(result, cnt);
	}
}
