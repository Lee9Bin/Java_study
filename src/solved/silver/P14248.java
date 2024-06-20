package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P14248 {
    static int n;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        graph = new ArrayList<>();
        for(int i = 0; i < n+1; i++) graph.add(new ArrayList<>());

        for (int i = 1 ; i < n+1; i++){
            int jump = Integer.parseInt(st.nextToken());
            if (i-jump >= 1){
                graph.get(i).add(i-jump);
            }
            if (i+jump <= n) {
                graph.get(i).add(i+jump);
            }
        }

        int start = Integer.parseInt(br.readLine());
        visited = new boolean[n+1];
        visited[start] = true;
        dfs(start);

        int result = 0;
        for (int i = 1; i < n+1; i++) {
            if(visited[i]) result++;
        }
        System.out.println(result);
    }

    public static void dfs(int start){
        for (Integer i : graph.get(start)){
            if(!visited[i]){
                visited[i] = true;
                dfs(i);
            }
        }
    }
}
