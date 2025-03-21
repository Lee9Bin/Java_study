package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P24912 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] cards = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N - 1; i++) {
			if (cards[i] != 0 && cards[i + 1] != 0 && cards[i] == cards[i + 1]) {
				System.out.println("-1");
				return;
			}
		}

		for (int i = 0; i < N; i++) {
			if (cards[i] == 0) {
				int left = (i > 0) ? cards[i - 1] : 0;
				int right = (i < N - 1 && cards[i + 1] != 0) ? cards[i + 1] : 0;

				for (int color = 1; color <= 3; color++) {
					if (color != left && (right == 0 || color != right)) {
						cards[i] = color;
						break;
					}
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(cards[i]);
			if (i < N - 1) {
				sb.append(" ");
			}
		}
		System.out.println(sb);
	}
}
