package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P17521 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		long w = Long.parseLong(st.nextToken());

		long[] coins = new long[n];

		for (int i = 0; i < n; i++)coins[i] = Long.parseLong(br.readLine());

		long coin = 0;
		for (int i = 0; i < n-1; i++){
			if (coin == 0 && coins[i] < coins[i+1]) {
				coin += w / coins[i];
				w = w % coins[i];
			}

			if (coins[i] > coins[i+1]){
				w += coin * coins[i];
				coin = 0;
			}
		}
		if (coin > 0) w+= coin * coins[n-1];
		System.out.println(w);


	}
}
