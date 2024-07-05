package solved.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1766 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] degree = new int[N+1];

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < N+1; i++){
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            degree[B] += 1;
            graph.get(A).add(B);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i < N+1; i++){
            if (degree[i] == 0) pq.add(i);
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()){
            int now = pq.poll();

            sb.append(now).append(" ");

            for (int i : graph.get(now)){
                degree[i] -= 1;
                if (degree[i] == 0){
                    pq.add(i);
                }
            }
        }
        System.out.println(sb);
    }


}
