package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P8979 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] countryies = new int[N][5];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				countryies[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Arrays.sort(countryies, (int[] left, int[] right) -> {
			return right[1] == left[1] ? (right[2] == left[2] ? right[3] - left[3] : right[2] - left[2])
					: right[1] - left[1];
		});

		
		int result = 1;
		for (int i = 0; i < N; i++) {
			if (countryies[i][4] == 0) {
				int cnt = 1;
				countryies[i][4] = result;
				for (int j = i + 1; j < N; j++) {
					if (countryies[i][1] == countryies[j][1] && countryies[i][2] == countryies[j][2]
							&& countryies[i][3] == countryies[j][3]) {
						countryies[j][4] = result;
						cnt++;

					} else {
						break;
					}
				}
				result += cnt;
			}
		}
		int answer = 0;
		for (int[] is : countryies) {
			if (is[0] == K) answer = is[4];
		}
		System.out.println(answer);
	}
}
