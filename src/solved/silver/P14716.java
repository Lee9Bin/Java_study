package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14716 {

    static final int[] dx = { -1, 0, 1, 0, 1, 1, -1, -1 };
    static final int[] dy = { 0, 1, 0, -1, 1, -1, 1, -1 };

    static int M,N;
    static int[][] map;
    static boolean[][] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        visited = new boolean[M][N];
        int result = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j] && map[i][j] == 1){
                    visited[i][j] = true;
                    result ++;
                    dfs(i,j);
                }
            }
        }
        System.out.println(result);
    }

    public static void dfs(int x, int y){

        for (int i = 0; i < 8; i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if ( 0<= nextX && nextX < M && 0 <= nextY && nextY < N){
                if (!visited[nextX][nextY] && map[nextX][nextY] == 1){
                    visited[nextX][nextY] = true;
                    dfs(nextX, nextY);
                }
            }
        }
    }
}
