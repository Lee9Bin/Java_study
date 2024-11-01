package solved.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11657 {

    static class Node {
        int start;
        int end;
        int cost;

        public Node(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Node> nodes = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            nodes.add(new Node(start, end, cost));
        }


        long[] dist = new long[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        // 노드 갯수만큼
        for (int i = 1; i < N + 1; i++) {
            for (int j = 0; j < M; j++) {
                Node node = nodes.get(j);

                if (dist[node.start] != Integer.MAX_VALUE && dist[node.end] > dist[node.start] + node.cost) {
                    dist[node.end] = dist[node.start] + node.cost;
                }
            }
        }

        boolean flag = true;
        for (int j = 0; j < M; j++) {
            Node node = nodes.get(j);

            if (dist[node.start] != Integer.MAX_VALUE && dist[node.end] > dist[node.start] + node.cost) {
                flag = false;
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        if (flag) {
            for (int i = 2; i < N + 1; i++) {
                if (dist[i] == Integer.MAX_VALUE) sb.append(-1).append("\n");
                else sb.append(dist[i]).append("\n");
            }
        } else {
            sb.append(-1);
        }
        System.out.println(sb);
    }
}
