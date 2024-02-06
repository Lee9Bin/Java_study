package ws.daily07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class P16926 {
	static int r;
	static int n;
	static int m;
	static int[][] map;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		map = new int[n+1][m+1];
		visited = new boolean[n+1][m+1];
		for (int i = 1; i < n+1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j<m+1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < Math.min(n+1, m+1)/2; i++) {
			rotation(i+1, i+1, 2*(n-2*i)+2*(m-2*i)-4);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < n+1; i++) {
			for (int j = 1; j <m+1; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	public static void rotation(int x, int y, int cnt) {
		Deque<Integer> que = new ArrayDeque<>();
		int[] dx = {1,0,-1,0};
		int[] dy = {0,1,0,-1};
		int index = 0;
		int nowx = x;
		int nowy = y;
		for (int i = 0; i < cnt; i++){
			que.add(map[x][y]);
			if (x + dx[index % 4] <= 0 || x + dx[index % 4] >= n+1
				||y + dy[index % 4] <= 0 || y + dy[index % 4] >=m+1
				||visited[x + dx[index % 4]][y + dy[index % 4]] == true) {
				
				index += 1;
			}
			x = x + dx[index % 4];
			y = y + dy[index % 4];
		}
		
		for (int i = 0; i<r; i++) {
			que.addFirst(que.pollLast());
		}
		index = 0;
		x = nowx;
		y = nowy;
		for (int i = 0; i < cnt; i++){
			map[x][y] = que.poll();
			visited[x][y] = true;
			if(x + dx[index % 4] <= 0 || x + dx[index % 4] >= n+1
					||y + dy[index % 4] <= 0 || y + dy[index % 4] >=m+1||visited[x + dx[index % 4]][y + dy[index % 4]] == true) {
				index += 1;
			}
			x = x + dx[index % 4];
			y = y + dy[index % 4];
		}
	}
}
