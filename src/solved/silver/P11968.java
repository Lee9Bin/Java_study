package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P11968 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		List<Integer> yours = new ArrayList<>();
		List<Integer> my = new ArrayList<>();
		boolean[] check = new boolean[2 * N + 1];

		for (int i = 0; i < N; i++) {
			int target = Integer.parseInt(br.readLine());
			yours.add(target);
			check[target] = true;
		}

		Collections.sort(yours);
		for (int i = 1; i < 2 * N + 1; i++) {
			if (!check[i])
				my.add(i);
		}

		int index = 0;
		int result = 0;
		for (int i = 0; i < N; i++) {
			while (index < N) {
				if (yours.get(i) < my.get(index)) {
					result++;
					index++;
					break;
				}
				index++;
			}
		}
		System.out.println(result);
	}
}
