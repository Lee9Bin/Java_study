package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2422 {

    static int N, M, result;
    static int[][] graph;
    static boolean[] visited;
    static int[] select;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N+1][N+1];
        visited = new boolean[N+1];

        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = 1;
            graph[b][a] = 1;
        }
        select = new int[3];
        dfs(1,0);
        System.out.println(result);
    }

    public static void dfs(int start, int depth){
        if (depth == 3){
            boolean flag = true;

            if (graph[select[0]][select[1]] == 1) flag = false;
            if (graph[select[0]][select[2]] == 1) flag = false;
            if (graph[select[1]][select[2]] == 1) flag = false;
            if (flag) result++;

            return;
        }

        for (int i = start; i < N+1; i++){
            select[depth] = i;
            dfs(i+1, depth + 1);
        }
    }
}
