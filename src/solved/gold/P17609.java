package solved.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P17609 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < T; i++) {
			String target = br.readLine();
			int start = 0;
			int end = target.length() - 1;

			sb.append(pallin(start, end, target, 0)).append("\n");

		}
		System.out.println(sb);
	}

	public static int pallin(int start, int end, String target, int count) {
		if (count >= 2)
			return 2;
		while (start < end) {
			char front = target.charAt(start);
			char back = target.charAt(end);

			if (front == back) {
				start++;
				end--;
			} else {
				return Math.min(
					pallin(start + 1, end, target, count + 1),
					pallin(start, end - 1, target, count + 1));
			}
		}

		return count;

	}
}
