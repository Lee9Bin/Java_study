package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P7465 {

    static int N,M, result;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int testNum = 1; testNum <= testCase; testNum++){
            result = 0;
            graph = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            for (int i = 0; i <= N; i++){
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < M; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            visited = new boolean[N+1];
            for (int i = 1; i < N+1; i ++){
                if (!visited[i]){
                    dfs(i);
                    result ++;
                }
            }
            sb.append("#").append(testNum).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int start){

        for (int next : graph.get(start)){
            if (!visited[next]){
                visited[next] = true;
                dfs(next);
            }
        }
    }
}
