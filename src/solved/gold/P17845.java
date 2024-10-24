package solved.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P17845 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] subjects = new int[K+1][2];

		for (int i = 1; i < K+1; i++){
			st = new StringTokenizer(br.readLine());
			subjects[i][0] = Integer.parseInt(st.nextToken());
			subjects[i][1] = Integer.parseInt(st.nextToken());
		}

		int[][] dp = new int[K+1][N+1];

		for (int i = 1; i < K+1; i++){
			for (int j = 0; j < N+1; j++){
				dp[i][j] = dp[i-1][j];
				if( j - subjects[i][1] >= 0){
					dp[i][j] = Math.max(dp[i][j], dp[i-1][j-subjects[i][1]] + subjects[i][0]);
				}
			}
		}
		System.out.println(dp[K][N]);
	}
}
