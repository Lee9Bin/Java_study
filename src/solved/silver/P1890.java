package solved.silver;

import java.util.*;
import java.io.*;

public class P1890 {

	static int[][] map;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		map = new int[N][N];

		for (int i = 0; i < N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		long[][] dp = new long[N][N];
		dp[0][0] = 1;

		for (int i = 0; i < N; i++){
			for (int j = 0; j < N; j++){
				if (dp[i][j] >= 1 && map[i][j] != 0){
					int nx = i + map[i][j];
					int ny = j + map[i][j];

					if (ny < N){
						dp[i][ny] += dp[i][j];
					}
					if (nx < N){
						dp[nx][j] += dp[i][j];
					}
					// for (int[] ints : dp) {
					// 	System.out.println(Arrays.toString(ints));
					// }
					// System.out.println();
				}
			}
		}
		System.out.println(dp[N-1][N-1]);
	}
}
