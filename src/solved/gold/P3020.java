package solved.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P3020 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		int[] check = new int[H+1];
		int[] dp = new int[H+1];
		int result = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++){
			int num = Integer.parseInt(br.readLine());
			if (i % 2 == 0){
				check[0] += 1;
				check[num] -= 1;
			}
			else {
				check[H - num] += 1;
			}
		}

		for(int i = 1; i < H+1; i++){
			dp[i] = dp[i-1] + check[i-1];
			min = Math.min(dp[i], min);
		}

		for (int i = 1; i < H+1; i++){
			if (min == dp[i]) result++;
		}
		StringBuilder sb = new StringBuilder();
		sb.append(min).append(" ").append(result);
		System.out.println(sb);
	}
}
