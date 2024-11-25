package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P29718 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];
		int[] sum = new int[M];

		for (int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < M; i++){
			for (int j = 0; j < N; j++){
				sum[i] += map[j][i];
			}
		}

		int n = Integer.parseInt(br.readLine());

		int result = 0;

		for (int i = 0; i < M-n+1; i++){
			int temp = 0;
			for (int j = i; j < i + n; j++) temp += sum[j];
			result = Math.max(temp, result);
		}
		System.out.println(result);
	}
}
