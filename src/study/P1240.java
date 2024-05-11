package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P1240 {

    static int N;
    static int M;
    static int start;
    static int end;
    static boolean[] visited;
    static StringBuilder sb  = new StringBuilder();
    static ArrayList<ArrayList<int[]>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
       for (int i = 0; i < N+1; i++){
           graph.add(new ArrayList<>());
       }

       for (int i = 0; i < N-1; i++){
           st = new StringTokenizer(br.readLine());
           int a = Integer.parseInt(st.nextToken());
           int b = Integer.parseInt(st.nextToken());
           int c = Integer.parseInt(st.nextToken());
           graph.get(a).add(new int[] {b,c});
           graph.get(b).add(new int[] {a,c});
       }
       for (int i = 0; i < M; i ++){
           visited = new boolean[N+1];
           st = new StringTokenizer(br.readLine());
           start = Integer.parseInt(st.nextToken());
           end = Integer.parseInt(st.nextToken());
           visited[start]= true;
           dfs(start, 0);
       }
        System.out.println(sb);
    }

    public static void dfs(int node, int distance){
        if (node == end){
            sb.append(distance).append("\n");
            return;
        }
        for (int[] now : graph.get(node)){
            if (!visited[now[0]]){
                visited[now[0]] = true;
                dfs(now[0], distance + now[1]);
            }
        }
    }
}
