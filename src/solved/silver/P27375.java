package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P27375 {

	static int n, k, result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		int[][] subjects = new int[n][3];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			subjects[i] = new int[] {w, s, e};
		}

		int[][] timeTable = new int[6][11];
		dfs(subjects, 0, timeTable, 0);
		System.out.println(result);
	}

	public static void dfs(int[][] subjects, int index, int[][] timeTable, int cost) {

		if (cost >= k) {
			if (cost == k) {
				boolean flag = true;
				for (int time : timeTable[5]) {
					if (time != 0) {
						flag = false;
						break;
					}
				}
				if (flag) {
					result++;
				}
			}
			return;
		}

		for (int i = index; i < n; i++) {
			int[] now = subjects[i];
			int w = now[0];
			int s = now[1];
			int e = now[2];
			boolean flag = true;

			for (int time = s; time <= e; time++) {
				if (timeTable[w][time] != 0) {
					flag = false;
					break;
				}
			}
			if (flag) {
				for (int time = s; time <= e; time++) {
					timeTable[w][time] += 1;
				}
				dfs(subjects, i + 1, timeTable, cost + (e - s + 1));
				for (int time = s; time <= e; time++) {
					timeTable[w][time] -= 1;
				}
			}
		}

	}
}
