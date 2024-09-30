package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P15903 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		PriorityQueue<Long> cards = new PriorityQueue<>();
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++){
			cards.add(Long.parseLong(st.nextToken()));
		}

		for (int i = 0; i <m; i++){
			Long first = cards.poll();
			Long second = cards.poll();
			cards.add(first+second);
			cards.add(first+second);
		}

		long result = 0;
		while (!cards.isEmpty()) result += cards.poll();

		System.out.println(result);
	}
}
