package solved.gold;

import java.io.*;
import java.util.*;

public class P5557 {
	static int N;
	static int[] nums;
	static int result;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		nums = new int[N];

		for (int i = 0; i < N; i++){
			nums[i] = Integer.parseInt(st.nextToken());
		}

		long[][] dp = new long[N][21];

		dp[0][nums[0]] = 1;

		for (int i = 1; i < N; i++){
			for (int j = 0; j < 21; j++){
				if (dp[i-1][j] > 0){
					if (j + nums[i] < 21) dp[i][j+nums[i]] += dp[i-1][j];
					if (j - nums[i] >= 0) dp[i][j-nums[i]] += dp[i-1][j];
				}
			}
		}

		System.out.println(dp[N-2][nums[N-1]]);
	}

}
