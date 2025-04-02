package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P25916 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] nums = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		int start = 0;
		int end = 0;
		int total = 0;
		int result = 0;

		while (end < N) {
			if (total + nums[end] <= M) {
				total += nums[end];
				end++;
			} else {
				total -= nums[start];
				start++;
			}
			result = Math.max(result, total);
		}
		System.out.println(result);
	}
}
