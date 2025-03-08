package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11999 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int maxMilk = 0;
		for (int a = 0; a * Y <= M; a++) {
			int b = (M - a * Y) / X;
			int current = a * Y + b * X;
			if (current > maxMilk) {
				maxMilk = current;
			}
		}

		System.out.println(maxMilk);
	}
}
