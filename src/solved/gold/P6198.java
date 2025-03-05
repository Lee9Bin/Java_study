package solved.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class P6198 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		ArrayDeque<Integer> deque = new ArrayDeque<>();

		long result = 0;
		for (int i = 0; i < N; i++) {
			int target = Integer.parseInt(br.readLine());

			if (deque.isEmpty()) {
				deque.add(target);
			} else {
				while (!deque.isEmpty()) {
					if (deque.peekLast() <= target)
						deque.pollLast();
					else
						break;
				}
				result += deque.size();
				deque.add(target);
			}
		}
		System.out.println(result);
	}
}
