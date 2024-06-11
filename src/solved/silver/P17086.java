package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P17086 {

    static final int[] dx = {-1, 0, 1, 0, -1, 1, 1, -1};
    static final int[] dy = {0, 1, 0, -1, 1, 1, -1, -1};

    static int N,M;
    static int[][] map;
    static int[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new int[N][M];

        for (int[] ints : visited) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if (map[i][j] == 1) bfs(i, j);
            }
        }

        int result = 0;
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                result = Math.max(result, visited[i][j]);
            }
        }
        System.out.println(result);
    }

    public static void bfs(int x, int y){
        ArrayDeque<int[]> que = new ArrayDeque<>();
        que.add(new int[] {x, y});
        visited[x][y] = 0;

        while (!que.isEmpty()){
            int[] now = que.pollFirst();

            for (int i = 0; i < 8; i++){
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if ( 0<=nx && 0 <= ny && nx < N && ny < M && map[nx][ny] == 0){
                    if (visited[nx][ny] > visited[now[0]][now[1]] + 1){
                        visited[nx][ny] = visited[now[0]][now[1]] + 1;
                        que.add(new int[] {nx, ny});
                    }

                }
            }

        }
    }
}
