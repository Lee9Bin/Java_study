package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P24447 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[] visited = new int[n + 1];
        int[] time = new int[n+1];
        Arrays.fill(visited, -1);


        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (List<Integer> integers : graph) {
            Collections.sort(integers);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(r);
        int cnt = 1;
        time[r] = cnt;
        visited[r] = 0;

        long result = 0;
        while (!queue.isEmpty()) {
            int nowV = queue.poll();

            for (int i : graph.get(nowV)) {
                if (visited[i] == -1) {
                    visited[i] = visited[nowV] + 1;
                    cnt ++;
                    result += (long) (visited[nowV] + 1) * cnt;
                    queue.add(i);
                }
            }
        }

        System.out.println(result);
    }
}