package solved.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P9205 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int test = 0; test < T; test++) {
            int N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            ArrayList<int[]> places = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                places.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
            }

            st = new StringTokenizer(br.readLine());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            ArrayDeque<int[]> heapq = new ArrayDeque<>();
            heapq.add(new int[]{startX, startY});
            boolean[] visited = new boolean[N];

            boolean flag = false;
            while (!heapq.isEmpty()) {
                int[] now = heapq.poll();
                int x = now[0];
                int y = now[1];

                if (Math.abs(x - endX) + Math.abs(y - endY) <= 1000) {
                    flag = true;
                    break;
                }

                for (int i = 0; i < N; i++) {
                    int[] next = places.get(i);
                    if (!visited[i] && Math.abs(x - next[0]) + Math.abs(y - next[1]) <= 1000) {
                        visited[i] = true;
                        heapq.add(new int[]{next[0], next[1]});
                    }
                }
            }
            if (flag) sb.append("happy");
            else sb.append("sad");
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
