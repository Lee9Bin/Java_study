package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P13565 {

    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};
    static int M,N;
    static boolean flag;
    static int[][] graph;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        graph = new int[M][N];

        for (int i = 0; i < M; i++){
            char[] temp = br.readLine().toCharArray();
            for (int j = 0; j < N; j++){
                graph[i][j] = temp[j] - '0';
            }
        }

        flag = false;

        visited = new boolean[M][N];
        for (int y = 0; y < N; y++){
            if (graph[0][y] == 0){
                visited[0][y] = true;
                dfs(0, y);
            }
        }

        System.out.println(flag ? "YES" : "NO");
    }

    public static void dfs(int x, int y){
        if (flag) return;
        if (x == M-1 && graph[x][y] == 0){
            flag = true;
            return;
        }

        for (int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if ( 0<= nx && nx < M && 0<= ny && ny < N){
                if (graph[nx][ny] == 0 && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    dfs(nx, ny);
                }
            }
        }
    }

}
