import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2293 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] coins = new int[n];
		int[] dp = new int[10001];
//		dp[0] = 1;
		
		for (int i = 0; i < n; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i = 0; i < n; i ++) {
			for (int j = 1; j < 10001; j++) {
				if (j - coins[i] < 0) continue;
				dp[j] = dp[j] + dp[j-coins[i]];
			}
		}
		System.out.println(dp[k]);
	}
}
