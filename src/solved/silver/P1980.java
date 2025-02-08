package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1980 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());

		int count = 0;
		int bottle = Integer.MAX_VALUE;

		for (int i = 0; i <= t / n; i++) {
			int tower = i;
			int meet = (t - (tower * n)) / m;
			int coke = t - (tower * n + meet * m);
			// System.out.println("burger = " + (tower + meet) + " coke = " + coke);

			if (coke <= bottle) {
				if (coke < bottle) {
					bottle = coke;
					count = tower + meet;
				} else {
					count = Math.max(tower + meet, count);
				}
			}
		}

		System.out.println(count + " " + bottle);
	}
}
