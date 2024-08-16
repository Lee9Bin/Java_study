package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P1755 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		HashMap<Integer, String> dic = new HashMap<>();
		dic.put(0, "zero");
		dic.put(1, "one");
		dic.put(2, "two");
		dic.put(3, "three");
		dic.put(4, "four");
		dic.put(5, "five");
		dic.put(6, "six");
		dic.put(7, "seven");
		dic.put(8, "eight");
		dic.put(9, "nine");

		StringTokenizer st = new StringTokenizer(br.readLine());

		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		String[][] result = new String[end - start + 1][2];

		int index = 0;
		for (int i = start; i < end + 1; i++) {
			char[] now = String.valueOf(i).toCharArray();

			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < now.length; j++) {
				sb.append(dic.get(now[j] - '0')).append(" ");
			}
			result[index] = new String[]{String.valueOf(i), sb.toString()};
			index++;
		}

		Arrays.sort(result, (String[] o1, String[] o2) -> {
			return o1[1].compareTo(o2[1]);
		});

		int cnt = 0;
		StringBuilder sb = new StringBuilder();
		for (String[] strings : result) {
			sb.append(strings[0]).append(" ");
			cnt++;
			if (cnt % 10 == 0) sb.append("\n");
		}
		System.out.println(sb);
	}
}
