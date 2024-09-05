package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2823 {

	static final int[] dx = {-1, 0, 1, 0};
	static final int[] dy = {0, 1, 0, -1};

	static int R, C, result;
	static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];

		for (int i = 0; i < R; i++){
			map[i] = br.readLine().toCharArray();
		}


		result = 0;
		for (int i = 0 ; i < R; i++){
			for (int j = 0; j < C; j++){
				if (map[i][j] == '.' && count(i, j) >= 3){
					result = 1;
				}
			}
		}
		System.out.println(result);
	}

	public static int count(int x, int y){

		int total = 0;
		for (int i = 0; i < 4; i++){
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			if (nextX < 0 || nextX >= R || nextY < 0 || nextY >= C) {
				total ++;
				continue;
			}
			if (map[nextX][nextY] == 'X'){
				total++;
			}
		}
		return total;
	}
}
