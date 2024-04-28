package solved.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1987 {
	static int result;
	static int R;
	static int C;
	static char[][] map;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		visited = new boolean[91];
		visited[map[0][0]] = true;
		back(0,0,1);
		System.out.println(result);
	}
	
	public static void back(int x, int y, int cnt) {
		result = Math.max(cnt, result);
		
		
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};
		
		for (int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			if (0 <= nextX && nextX < R && 0 <= nextY && nextY < C) {
				if (!visited[map[nextX][nextY]]) {
					visited[map[nextX][nextY]] = true;
					back(nextX, nextY, cnt + 1);
					visited[map[nextX][nextY]] = false;
				}
			}
		}
	}
}

