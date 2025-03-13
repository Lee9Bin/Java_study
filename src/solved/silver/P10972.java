package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10972 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] nums = new int[N];

		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		if (nextPermutation(nums)) {
			StringBuilder sb = new StringBuilder();
			for (int num : nums) {
				sb.append(num).append(" ");
			}
			System.out.println(sb);
		} else {
			System.out.println("-1");
		}
	}

	public static boolean nextPermutation(int[] arr) {
		int n = arr.length;
		int i = n - 1;

		while (i > 0 && arr[i - 1] >= arr[i]) {
			i--;
		}

		if (i <= 0) {
			return false;
		}

		int j = n - 1;
		while (arr[j] <= arr[i - 1]) {
			j--;
		}

		swap(arr, i - 1, j);

		j = n - 1;
		while (i < j) {
			swap(arr, i, j);
			i++;
			j--;
		}

		return true;
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
