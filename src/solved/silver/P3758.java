package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P3758 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int testCase = 0; testCase < T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int myId = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			int[] submissions = new int[n + 1];
			int[] lastSubmission = new int[n + 1];
			int[][] bestScores = new int[n + 1][k + 1];

			for (int time = 1; time <= m; time++) {
				st = new StringTokenizer(br.readLine());
				int teamId = Integer.parseInt(st.nextToken());
				int problemId = Integer.parseInt(st.nextToken());
				int score = Integer.parseInt(st.nextToken());

				submissions[teamId]++;
				lastSubmission[teamId] = time;

				if (score > bestScores[teamId][problemId]) {
					bestScores[teamId][problemId] = score;
				}
			}

			int[] totalScore = new int[n + 1];
			for (int team = 1; team <= n; team++) {
				int sum = 0;
				for (int prob = 1; prob <= k; prob++) {
					sum += bestScores[team][prob];
				}
				totalScore[team] = sum;
			}

			int rank = 1;
			for (int team = 1; team <= n; team++) {
				if (team == myId)
					continue;

				if (totalScore[team] > totalScore[myId]) {
					rank++;
				} else if (totalScore[team] == totalScore[myId]) {
					if (submissions[team] < submissions[myId]) {
						rank++;
					} else if (submissions[team] == submissions[myId]) {
						if (lastSubmission[team] < lastSubmission[myId]) {
							rank++;
						}
					}
				}
			}
			sb.append(rank).append("\n");
		}
		System.out.println(sb);
	}
}
