package solved.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P15683 {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static ArrayList<int[]> cctvs;
	static int[] angleList;
	static int result;
	final static int[] dx = {-1,0,1,0};
	final static int[] dy = {0,1,0,-1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		cctvs = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0 && map[i][j] != 6) {
					cctvs.add(new int[] { map[i][j], i, j });
				}
			}
		}
		// 입력 끝
		angleList = new int[cctvs.size()];
		result = Integer.MAX_VALUE;
		makeAngleList(0);
		System.out.println(result);
	}

	public static void makeAngleList(int cnt) {
		if (cnt == cctvs.size()) {
			int total = 0;
			visited = new boolean[N][M];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] != 0 ) {
						visited[i][j] = true;
					}
				}
			}
			
			for (int i = 0; i < cctvs.size(); i++) {
				blindCount(cctvs.get(i), angleList[i]);
			}
			
			for (int i = 0; i< N; i++) {
				for (int j = 0; j< M; j++) {
					if (!visited[i][j]) total ++;
				}
			}
			result = Math.min(result, total);
			return;
		}
		int last = 4;
		if (cctvs.get(cnt)[0] == 2) last = 2;
		if (cctvs.get(cnt)[0] == 5) last = 1;
		for (int i = 0; i < last; i++) {
			angleList[cnt] = i;
			makeAngleList(cnt + 1);
		}
	}

	public static void blindCount(int[] cctv, int angle) {
		int cctvNumber = cctv[0];
		int x = cctv[1];
		int y = cctv[2];

		if (cctvNumber == 1) {
			int nextX = x+dx[angle];
			int nextY = y+dy[angle];
			while(true) {
				if (nextX < 0 || nextX>= N || nextY < 0 || nextY >= M || map[nextX][nextY] == 6) {
					break;
				}
				if (visited[nextX][nextY] == false) {
					visited[nextX][nextY] = true;
				}
				nextX += dx[angle];
				nextY += dy[angle];
			}

		}
		if (cctvNumber == 2) {
			for (int i = 0; i<2; i++) {
				int nextX = x+dx[angle];
				int nextY = y+dy[angle];
				while(true) {
					if (nextX < 0 || nextX>= N || nextY < 0 || nextY >= M || map[nextX][nextY] == 6) {
						break;
					}
					if (visited[nextX][nextY] == false) {
						visited[nextX][nextY] = true;
					}
					nextX += dx[angle];
					nextY += dy[angle];
				}
				angle += 2;
			}
		}
		if (cctvNumber == 3) {
			for (int i = 0; i<2; i++) {
				int nextX = x+dx[angle];
				int nextY = y+dy[angle];
				while(true) {
					if (nextX < 0 || nextX>= N || nextY < 0 || nextY >= M || map[nextX][nextY] == 6) {
						break;
					}
					if (visited[nextX][nextY] == false) {
						visited[nextX][nextY] = true;
					}
					nextX += dx[angle];
					nextY += dy[angle];
				}
				angle += 1;
				angle %= 4;
			}
		}
		if (cctvNumber == 4) {
			for(int i = 0; i<3; i++) {
				int nextX = x+dx[angle];
				int nextY = y+dy[angle];
				while(true) {
					if (nextX < 0 || nextX>= N || nextY < 0 || nextY >= M || map[nextX][nextY] == 6) {
						break;
					}
					if (visited[nextX][nextY] == false) {
						visited[nextX][nextY] = true;
					}
					nextX += dx[angle];
					nextY += dy[angle];
				}
				angle += 1;
				angle %= 4;
			}
		}
		if (cctvNumber == 5) { 
			for (int i = 0; i < 4; i++) {
				int nextX = x+dx[i];
				int nextY = y+dy[i];
				while(true) {
					if (nextX < 0 || nextX>= N || nextY < 0 || nextY >= M || map[nextX][nextY] == 6) {
						break;
					}
					if (visited[nextX][nextY] == false) {
						visited[nextX][nextY] = true;
					}
					nextX += dx[i];
					nextY += dy[i];
				}
			}
		}

	}
}
