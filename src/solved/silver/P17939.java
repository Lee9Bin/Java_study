package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P17939 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] coins = new int[n];

		for (int i = 0; i < n; i++){
			coins[i] = Integer.parseInt(st.nextToken());
		}

		int result = 0;
		int start = 0;
		for (int i = n-1; i >= 0; i--){
			if (coins[i] > start) start = coins[i];
			else {
				result += start - coins[i];
			}
		}
		System.out.println(result);
	}
}
