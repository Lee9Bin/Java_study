package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class P3022 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		HashMap<String, Integer> kids = new HashMap<>();

		int count = 0;
		int result = 0;

		for (int i = 0; i < N; i++) {
			String name = br.readLine();

			if (count - kids.getOrDefault(name, 0) < kids.getOrDefault(name, 0)) {
				result++;
			}
			count++;
			kids.put(name, kids.getOrDefault(name, 0) + 1);

		}

		System.out.println(result);
	}
}
