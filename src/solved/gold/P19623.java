package solved.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class P19623 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[][] meeting = new int[N+1][3];

		for (int i = 1; i < N+1; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			meeting[i] = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
		}

		Arrays.sort(meeting, Comparator.comparingInt((int[] o) -> o[1]));


		int[] dp = new int[N+1];

		for (int i = 1; i < N+1; i++){
			int start = 0;
			int end = i-1;
			int nowMeetingStart = meeting[i][0];
			int nowMeetingPeoples = meeting[i][2];
			dp[i] = nowMeetingPeoples;
			while (start <= end){
				int mid = (start + end) / 2;
				int beforeMeetingEnd = meeting[mid][1];

				if (beforeMeetingEnd <= nowMeetingStart){
					dp[i] = Math.max(dp[i-1], dp[mid] + nowMeetingPeoples);
					start = mid + 1;
				}
				else{
					end = mid - 1;
				}
			}
		}
		System.out.println(dp[N]);
	}
}
