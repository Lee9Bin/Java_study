package solved.gold;

import java.io.*;
import java.util.*;

public class P6593 {

	static int L,R,C;
	static char[][][] map;

	static int[] dx = {-1, 0, 1, 0, 0, 0};
	static int[] dy = {0, 1 ,0 ,-1, 0, 0};
	static int[] dz = {0, 0, 0, 0, 1, -1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		while (true){
			StringTokenizer st = new StringTokenizer(br.readLine());

			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			if (L == 0 && R == 0 && C == 0) break;
			map = new char[L][R][C];
			int[][][] visited = new int[L][R][C];

			for (int[][] ints : visited) {
				for (int[] anInt : ints) {
					Arrays.fill(anInt, Integer.MAX_VALUE);
				}
			}

			PriorityQueue<int[]> heapq = new PriorityQueue<>(Comparator.comparingInt((int[] o) -> o[3]));
			for (int i = 0; i < L; i++){
				for (int j = 0; j < R+1; j++){
					String temp = br.readLine();
					if(temp.isEmpty()) continue;
					for (int k = 0; k < C; k++){
						//좌표, 시간
						if (temp.charAt(k) == 'S') {
							heapq.add(new int[] {i, j, k, 0});
							visited[i][j][k] = 0;
						}
						map[i][j][k] = temp.charAt(k);
					}
				}
			}

			int result = 0;
			while (!heapq.isEmpty()){
				int[] now = heapq.poll();
				int x = now[1];
				int y = now[2];
				int z = now[0];
				int count = now[3];

				if (map[z][x][y] == 'E') {
					result = count;
					break;
				}

				for (int i = 0; i < 6; i++){
					int nextX = x + dx[i];
					int nextY = y + dy[i];
					int nextZ = z + dz[i];

					if (0 <= nextX && nextX < R && 0 <= nextY && nextY < C && 0<= nextZ && nextZ < L && map[nextZ][nextX][nextY] != '#'){
						if (visited[nextZ][nextX][nextY] > count+1){
							heapq.add(new int[] {nextZ, nextX, nextY, count+1});
							visited[nextZ][nextX][nextY] = count+1;
						}
					}
				}
			}

			if (result != 0){
				sb.append("Escaped in ").append(result).append(" minute(s).").append("\n");
			}
			else{
				sb.append("Trapped!").append("\n");
			}
		}
		System.out.println(sb);
	}
}
