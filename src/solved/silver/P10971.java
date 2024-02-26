package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10971 {
    static int N,result;
    static boolean[] visited;
    static int[][] graph;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        result = Integer.MAX_VALUE;
        for (int i = 0; i < N; i ++) {
            visited = new boolean[N];
            visited[i] = true;
            dfs(i,1,0,i);
        }
        System.out.println(result);
    }

    public static void dfs(int start, int cnt, int total, int end) {
        //if (result < total) return;
        if (cnt == N && graph[start][end] > 0) {
            result = Math.min(result, total + graph[start][end]);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (graph[start][i] > 0 && !visited[i]) {
                visited[i] = true;
                dfs(i, cnt + 1, total+ graph[start][i], end);
                visited[i] = false;
            }
        }
    }
}
