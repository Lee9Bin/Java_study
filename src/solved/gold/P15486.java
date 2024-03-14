package solved.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P15486 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+1];
		
		ArrayList<int[]> sangdam = new ArrayList<>();
		sangdam = new ArrayList<>();
		sangdam.add(new int[] {0,0});
		for (int i = 1 ; i < N+1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int day = Integer.parseInt(st.nextToken());
			int point = Integer.parseInt(st.nextToken());
			sangdam.add(new int[] {day, point});
		}
		
		for (int i = 1; i < N+1; i++) {
			//현재 i일 + sangdam.get(i)[0] - 1 = 일을 마치고 끝난날 
			dp[i] = Math.max(dp[i-1], dp[i]);
			if (i + sangdam.get(i)[0] - 1 < N+1) {
				dp[i + sangdam.get(i)[0] - 1] = Math.max(dp[i + sangdam.get(i)[0] - 1], dp[i-1] + sangdam.get(i)[1]); 
			}
		}
		
		System.out.println(dp[N]);
		

	}
}
