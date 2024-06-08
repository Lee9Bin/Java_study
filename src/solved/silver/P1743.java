package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1743 {

    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};
    static int N,M,K, cnt;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x-1][y-1] = 1;
        }

        int result = 0;
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if (map[i][j] == 1 && !visited[i][j]){
                    visited[i][j] = true;
                    cnt = 1;
                    dfs(i, j);
                    result = Math.max(result, cnt);
                }
            }
        }
        System.out.println(result);
    }

    public static void dfs(int x, int y){

        for (int i = 0; i < 4; i ++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if ( 0 <= nx && nx < N && 0 <= ny && ny < M ){
                if (!visited[nx][ny] && map[nx][ny] == 1){
                    visited[nx][ny] = true;
                    cnt ++;
                    dfs(nx, ny);
                }
            }
        }
    }


}
