package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class P11645 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			HashMap<String, Integer> map = new HashMap<>();

			for (int i = 0; i < N; i++) {
				String name = br.readLine();
				if (!map.containsKey(name)) map.put(name, 1);
			}
			sb.append(map.size()).append("\n");

		}
		System.out.println(sb);
	}
}

