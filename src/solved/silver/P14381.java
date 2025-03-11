package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class P14381 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= T; i++) {
			int N = Integer.parseInt(br.readLine());
			HashMap<Integer, Boolean> visited = new HashMap<>();
			Set<Integer> nums = new HashSet<>();
			int index = 1;
			while (true) {
				int target = N * index;
				if (visited.containsKey(target)) {
					break;
				}
				visited.put(target, true);
				String check = String.valueOf(target);
				for (int j = 0; j < check.length(); j++) {
					nums.add(check.charAt(j) - '0');
				}
				if (nums.size() == 10) {
					break;
				}
				index++;

			}
			if (nums.size() == 10) {
				sb.append("Case #").append(i).append(": ").append(N * index).append("\n");
			} else {
				sb.append("Case #").append(i).append(": INSOMNIA").append("\n");
			}
		}

		System.out.println(sb);
	}
}
