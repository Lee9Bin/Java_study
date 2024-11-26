package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P15645 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[][] nums = new int[n+1][3];

		for (int i = 1; i < n+1; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++){
				nums[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] maxDp = new int[n+1][3];
		int[][] minDp = new int[n+1][3];

		for (int i = 1; i < n+1; i++){
			//첫번쨰 칸
			maxDp[i][0] = Math.max(maxDp[i-1][0], maxDp[i-1][1]) + nums[i][0];
			minDp[i][0] = Math.min(minDp[i-1][0], minDp[i-1][1]) + nums[i][0];

			//두번째 칸
			maxDp[i][1] = Math.max(maxDp[i-1][0], maxDp[i-1][1]);
			maxDp[i][1] = Math.max(maxDp[i][1], maxDp[i-1][2]) + nums[i][1];
			minDp[i][1] = Math.min(minDp[i-1][0], minDp[i-1][1]);
			minDp[i][1] = Math.min(minDp[i][1], minDp[i-1][2]) + nums[i][1];

			//세번쨰 칸
			maxDp[i][2] = Math.max(maxDp[i-1][1], maxDp[i-1][2]) + nums[i][2];
			minDp[i][2] = Math.min(minDp[i-1][1], minDp[i-1][2]) + nums[i][2];
		}

		int maxResult = 0;
		int minResult = Integer.MAX_VALUE;

		for (int i = 0; i < 3; i++){
			maxResult = Math.max(maxResult, maxDp[n][i]);
			minResult = Math.min(minResult, minDp[n][i]);
		}

		StringBuilder sb = new StringBuilder();
		sb.append(maxResult).append(" ").append(minResult);
		System.out.println(sb);
	}
}
