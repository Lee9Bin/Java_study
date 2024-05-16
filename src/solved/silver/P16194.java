import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P16194 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[]cards = new int[n+1];
		
		for (int i = 1; i < n+1; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[10001];
		
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		
		for (int i = 1; i < n+1; i++) {
			for (int j = 1; j < 10001; j++ ) {
				if (j-i <0) continue;
				dp[j] = Math.min(dp[j], dp[j-i] + cards[i]);
			}
		}
		
		System.out.println(dp[n]);
	}
}
