package solved.gold;

import java.io.*;
import java.util.*;

public class P2294 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] coins = new int[n+1];

		for (int i = 1; i < n+1; i++){
			coins[i] = Integer.parseInt(br.readLine());
		}

		int[] dp = new int[k+1];

		Arrays.sort(coins);
		Arrays.fill(dp, Integer.MAX_VALUE-1);
		dp[0] = 0;
		for (int i = 1; i <= n; i++){
			int coin = coins[i];
			for (int j = coin; j <= k; j++){
				dp[j] = Math.min(dp[j], dp[j-coin] + 1);
			}
		}

		if(dp[k] == Integer.MAX_VALUE-1){
			System.out.println(-1);
		}
		else{
			System.out.println(dp[k]);
		}
	}
}
