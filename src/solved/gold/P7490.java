package solved.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P7490 {

	static List<String> result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		StringBuilder temp = new StringBuilder();

		for (int i = 0; i < T; i++) {
			result = new ArrayList<>();
			int n = Integer.parseInt(br.readLine());
			StringBuilder sb = new StringBuilder();
			sb.append(1);
			dfs(sb, 2, n, 1);

			Collections.sort(result);
			for (String s : result) {
				temp.append(s).append("\n");
			}
			temp.append("\n");

		}

		System.out.println(temp);
	}

	public static void dfs(StringBuilder now, int num, int n, int total) {
		if (num == n + 1) {
			String cal = now.toString().replace(" ", "");
			int sum = 0, numVal = 0;
			int sign = 1;
			for (int i = 0; i < cal.length(); i++) {
				char c = cal.charAt(i);
				if (Character.isDigit(c)) {
					numVal = numVal * 10 + (c - '0');
				} else {
					sum += sign * numVal;
					numVal = 0;
					sign = (c == '+') ? 1 : -1;
				}
			}
			sum += sign * numVal;

			if (sum == 0) {
				result.add(now.toString());
			}
			return;
		}

		now.append("+").append(num);
		dfs(now, num + 1, n, total + num);
		now.delete(now.length() - 2, now.length());

		now.append("-").append(num);
		dfs(now, num + 1, n, total - num);
		now.delete(now.length() - 2, now.length());

		now.append(" ").append(num);
		dfs(now, num + 1, n, total);
		now.delete(now.length() - 2, now.length());
	}
}
