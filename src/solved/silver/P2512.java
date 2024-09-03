package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2512 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int max = Integer.parseInt(br.readLine());

		int[] cost = new int[n];
		for (int i = 0; i < n; i++){
			cost[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(cost);
		int start = 0;
		int end = cost[n-1];
		int result = 0;
		while (true){
			if (start > end) {
				break;
			}
			int mid = (start + end) / 2;
			int total = 0;

			for (int i = 0; i < n; i++){
				if (cost[i] <= mid){
					total += cost[i];
				}
				else{
					total += mid;
				}
			}
			if (total > max){
				end = mid - 1;
			}
			else{
				result = Math.max(result, mid);
				start = mid + 1;
			}

		}
			System.out.println(result);
	}
}
