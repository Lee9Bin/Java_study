package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P33257 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		int[] densities = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			densities[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(densities);

		int materialCount = (N > 0) ? 1 : 0;

		for (int i = 1; i < N; i++) {
			if (densities[i] - densities[i - 1] >= E) {
				materialCount++;
			}
		}

		System.out.println(materialCount);
	}
}
