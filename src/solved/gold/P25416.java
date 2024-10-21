package solved.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P25416 {

	static final int[] dx = {-1, 0, 1, 0};
	static final int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[][] map = new int[5][5];
		int[][] visited = new int[5][5];

		for (int[] ints : visited) {
			Arrays.fill(ints, Integer.MAX_VALUE);
		}

		for (int i = 0; i < 5; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		visited[r][c] = 0;
		ArrayDeque<int[]> deque = new ArrayDeque<>();
		deque.add(new int[] {r, c, 0});

		int result = Integer.MAX_VALUE;
		while (!deque.isEmpty()){
			int[] now = deque.pollFirst();

			if (map[now[0]][now[1]] == 1){
				result = Math.min(result, now[2]);
			}

			for (int i = 0; i < 4; i++){
				int nextX = now[0] + dx[i];
				int nextY = now[1] + dy[i];

				if (0 <= nextX && nextX < 5 && 0 <= nextY && nextY < 5 && map[nextX][nextY] != -1){
					if (visited[nextX][nextY] > now[2] + 1){
						visited[nextX][nextY] = now[2] + 1;
						deque.add(new int[] {nextX, nextY, now[2] + 1});
					}
				}
			}
		}
		if (result == Integer.MAX_VALUE){
			System.out.println(-1);
		}
		else{
			System.out.println(result);
		}
	}
}
