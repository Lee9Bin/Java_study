package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.HashSet;
import java.util.StringTokenizer;

public class P2531 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int[] sushi = new int[n];

		for (int i = 0; i < n; i++){
			sushi[i] = Integer.parseInt(br.readLine());
		}

		int[] kinds = new int[d+1];
		int kindCount = 0;
		int kCount = 0;
		int result = 0;
		for (int i = 0; i < n+k; i++){
			int nowSushi = sushi[i%n];
			if (kinds[nowSushi] == 0){
				//없던 종류
				kindCount += 1;
				kinds[nowSushi] += 1;
			}
			else{
				//있던 종류
				kinds[nowSushi] += 1;
			}
			kCount += 1;
			if (kCount == k){
				if (kinds[c] == 0){
					result = Math.max(kindCount+1, result);
				}
				else {
					result = Math.max(kindCount, result);
				}

				kCount -= 1;
				kinds[sushi[(i - k + 1)%n]] -= 1;
				if (kinds[sushi[(i - k + 1)%n]] == 0){
					kindCount -= 1;
				}
			}
		}
		System.out.println(result);
	}
}
