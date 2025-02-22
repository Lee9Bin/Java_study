package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P20300 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		long[] nums = new long[N];

		for (int i = 0; i < N; i++) {
			nums[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(nums);

		long result = 0;
		if (N % 2 == 0) {
			for (int i = 0; i < N / 2; i++) {
				result = Math.max(result, nums[i] + nums[N - i - 1]);
			}
		} else {
			result = nums[N - 1];
			for (int i = 0; i < N / 2; i++) {
				result = Math.max(result, nums[i] + nums[N - i - 2]);
			}
		}

		System.out.println(result);
	}
}
