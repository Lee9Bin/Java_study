package solved.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class p1655 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> left = new PriorityQueue<>((Integer o1, Integer o2) -> {
			return o2 - o1;
		});
		PriorityQueue<Integer> right = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());

			if (i == 0)
				left.add(num);

			else if (i % 2 == 0) {
				left.add(num);
				int bigNum = left.poll();
				right.add(bigNum);
				left.add(right.poll());
			} else {
				left.add(num);
				int bigNum = left.poll();
				right.add(bigNum);
			}

			sb.append(left.peek()).append("\n");
		}
		System.out.println(sb);
	}
}