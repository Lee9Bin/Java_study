package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P17829 {

	static int[][] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		graph = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(polling(N, 0, 0));
	}

	public static int polling(int size, int startX, int startY) {
		if (size == 2) {
			PriorityQueue<Integer> heapq = new PriorityQueue<>();
			for (int i = startX; i < startX + 2; i++) {
				for (int j = startY; j < startY + 2; j++) {
					heapq.add(graph[i][j]);
				}
			}
			int target = 0;
			for (int i = 0; i < 3; i++) {
				target = heapq.poll();
			}
			return target;
		} else {
			PriorityQueue<Integer> heapq = new PriorityQueue<>();
			heapq.add(polling(size / 2, startX, startY));
			heapq.add(polling(size / 2, startX, startY + size / 2));
			heapq.add(polling(size / 2, startX + size / 2, startY));
			heapq.add(polling(size / 2, startX + size / 2, startY + size / 2));
			int target = 0;
			for (int i = 0; i < 3; i++) {
				target = heapq.poll();
			}
			return target;
		}
	}
}
