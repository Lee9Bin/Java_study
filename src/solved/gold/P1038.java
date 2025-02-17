package solved.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class P1038 {

	static ArrayList<Long> result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		result = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			dfs(i, 1);
		}

		Collections.sort(result);
		if (result.size() < N)
			System.out.println(-1);
		else {
			System.out.println(result.get(N));
		}
	}

	public static void dfs(long now, int count) {

		if (count > 10)
			return;

		result.add(now);
		for (int i = 0; i < now % 10; i++) {
			dfs(now * 10 + i, count + 1);
		}

	}
}
