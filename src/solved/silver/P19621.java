package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class P19621 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[][] meeting = new int[N + 1][3];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			meeting[i] = new int[] {Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken())};
		}

		Arrays.sort(meeting, 1, N + 1, Comparator.comparingInt(o -> o[1]));

		int[] dp = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			int nowStart = meeting[i][0];
			int nowPeople = meeting[i][2];

			int start = 0;
			int end = i - 1;
			int target = 0;
			while (start <= end) {
				int mid = (start + end) / 2;
				if (meeting[mid][1] <= nowStart) {
					target = mid;
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}

			dp[i] = Math.max(dp[i - 1], dp[target] + nowPeople);
		}
		System.out.println(dp[N]);
	}
}
