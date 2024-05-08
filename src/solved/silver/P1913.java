import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1913 {

	static final int[] dx = { 1, 0, -1, 0 };
	static final int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int target = Integer.parseInt(br.readLine());

		int[][] map = new int[n][n];

		makeMap(n, target, map);

	}

	public static void makeMap(int n,int target ,int[][] map) {
		
		int result[] = new int[2];
		int x = 0;
		int y = 0;
		int nowNum = n * n;
		int index = 0;
		for (int i = 0; i < n * n; i++) {
			if (nowNum == target) {
				result[0] = x;
				result[1] = y;
			}
			map[x][y] = nowNum--;
			int nextX = x + dx[index];
			int nextY = y + dy[index];
			if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n || map[nextX][nextY] != 0) {
				index = (index + 1) % 4;
				nextX = x + dx[index];
				nextY = y + dy[index];
			}
			x = nextX;
			y = nextY;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int[] is : map) {
			for (int i : is) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
		}
		
		for (int i : result) {
			sb.append(i+1).append(" ");
		}
		System.out.println(sb);

	}
}
