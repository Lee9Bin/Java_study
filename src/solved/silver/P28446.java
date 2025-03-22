package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P28446 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int M = Integer.parseInt(br.readLine());
		HashMap<Integer, Integer> info = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			if (command == 1) {
				int x = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				info.put(w, x);
			} else {
				int w = Integer.parseInt(st.nextToken());
				sb.append(info.get(w)).append("\n");
			}
		}
		System.out.println(sb);
	}
}
