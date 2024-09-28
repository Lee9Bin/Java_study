package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P6118 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int[] visited = new int[N + 1];
        Arrays.fill(visited, -1);
        visited[1] = 0;
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{1, 0});

        int dist = 0;
        while (!deque.isEmpty()) {
            int[] now = deque.pollFirst();

            for (int next : graph.get(now[0])) {
                if (visited[next] == -1) {
                    visited[next] = now[1] + 1;
                    dist = Math.max(visited[next], dist);
                    deque.add(new int[]{next, now[1] + 1});
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N + 1; i++) {
            if (dist == visited[i]) {
                sb.append(i);
                break;
            }
        }
        sb.append(" ").append(dist);

        int count = 0;
        for (int i : visited) {
            if (i == dist) count++;
        }
        sb.append(" ").append(count);
        System.out.println(sb);
    }
}
