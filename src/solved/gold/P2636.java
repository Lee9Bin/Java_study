package solved.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2636 {
	static int n;
	static int m;
	static int[][] map;
	static int cheeses;
	static int time;
	static int cnt;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		
		for (int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) cnt +=1;
			}
		}
		
		while (true) {
			Queue<int[]> cheeseList = new ArrayDeque<>();
			for (int i = 0; i<n; i++) {
				for(int j = 0; j<m; j++) {
					if (map[i][j] == 1) {
						if (findCheese(i, j)) {
							cheeseList.add(new int[] {i,j});
						}
					}
				}
			}
			
			if (cheeseList.isEmpty()) break;
			
			cnt = cnt - cheeseList.size();
			if (cnt == 0) {
				cheeses = cheeseList.size();
			}
			while (!cheeseList.isEmpty()) {
				int[] now = cheeseList.poll();
				map[now[0]][now[1]] = 0;
			}
			time += 1;
			
		}
		
		System.out.println(time);
		System.out.println(cheeses);
	}
	
	public static boolean findCheese(int x, int y) {
		Queue<int[]> que = new ArrayDeque<>();
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};
		
		boolean[][] visited = new boolean[n][m];
		
		que.add(new int[] {x,y});
		
		visited[x][y] = true;
		
		while (!que.isEmpty()) {
			int[] now = que.poll();
			
			for (int i = 0; i < 4; i++) {
				int nextX = now[0] + dx[i];
				int nextY = now[1] + dy[i];
				if ( 0<= nextX && 0 <= nextY && nextX < n && nextY <m) {
					if (map[nextX][nextY] == 0 && visited[nextX][nextY] == false) {
						que.add(new int[] {nextX, nextY});
						visited[nextX][nextY] = true;
					}					
				}
			}
		}
		if (visited[n-1][m-1]) {
			return true;
		}
		else {
			return false;
		}
	}
}
