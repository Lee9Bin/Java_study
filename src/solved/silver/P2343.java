package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2343 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int result = Integer.MAX_VALUE;

		int end = 0;
		int start = Integer.MIN_VALUE;
		int[] classes = new int[N];
		for (int i = 0; i < N; i++){
			classes[i] = Integer.parseInt(st.nextToken());
			end += classes[i];
			start = Math.max(start, classes[i]);
		}



		while (start <= end){
			int mid = (start + end) / 2;

			int count = 0;
			int sum = 0;
			for (int i = 0; i < N; i++) {
				if (sum + classes[i] > mid) {
					count++;
					sum = 0;
				}
				sum += classes[i];
			}
			if (sum != 0) {
				count ++;
			}

			if (count <= M){
				end = mid - 1;
				result = Math.min(result, mid);
			}
			else {
				start = mid + 1;
			}
		}
		System.out.println(result);
	}
}
