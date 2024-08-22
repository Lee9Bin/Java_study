package solved.silver;

import java.util.*;
import java.io.*;

public class P12852 {
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+1];

		Arrays.fill(dp, Integer.MAX_VALUE);

		dp[N] = 0;

		PriorityQueue<ArrayDeque<Integer>> temp = new PriorityQueue<>(Comparator.comparingInt(ArrayDeque::peekFirst));

		ArrayDeque<Integer> start = new ArrayDeque<>();
		start.addLast(0);
		start.addLast(N);
		temp.add(start);

		ArrayDeque<Integer> result = new ArrayDeque<>();

		while (!temp.isEmpty()){
			ArrayDeque<Integer> now = temp.poll();

			int last = now.peekLast();
			int cnt = now.peekFirst();
			if (last == 1) {
				result = now;
				break;
			}

			if (last % 3 == 0 && dp[last / 3] > cnt + 1){
				dp[last / 3] = cnt + 1;
				ArrayDeque<Integer> next = new ArrayDeque<>(now);
				next.pollFirst();

				next.addFirst(cnt+1);
				next.addLast(last / 3);

				temp.add(next);
			}
			if (last % 2 == 0 && dp[last / 2] > cnt + 1){
				dp[last / 2] = cnt + 1;
				ArrayDeque<Integer> next = new ArrayDeque<>(now);
				next.pollFirst();

				next.addFirst(cnt+1);
				next.addLast(last / 2);

				temp.add(next);
			}

			if (last - 1 > 0 && dp[last - 1] > cnt + 1){
				dp[last - 1] = cnt + 1;
				ArrayDeque<Integer> next = new ArrayDeque<>(now);
				next.pollFirst();

				next.addFirst(cnt+1);
				next.addLast(last -1 );

				temp.add(next);
			}

		}

		StringBuilder sb = new StringBuilder();
		sb.append(result.pollFirst()).append("\n");
		while (!result.isEmpty()){
			sb.append(result.pollFirst()).append(" ");
		}

		System.out.println(sb);
	}
}
