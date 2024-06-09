package solved.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2589 {

    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};
    static int N, M, result;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        for (int i = 0; i < N; i++){
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if (map[i][j] == 'L') bfs(i, j);
            }
        }
        System.out.println(result);
    }

    public static void bfs(int x, int y){
        ArrayDeque<int[]> que = new ArrayDeque<>();
        int[][] visited = new int[N][M];
        for (int[] ints : visited) {
            Arrays.fill(ints, -1);
        }
        visited[x][y] = 0;
        que.add(new int[] {x, y});

        int dist = 0;
        while (!que.isEmpty()){
            int[] now = que.pollFirst();

            for(int i = 0; i < 4; i++){
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if ( 0<= nx && nx < N && 0<= ny && ny < M && visited[nx][ny] == -1 && map[nx][ny] == 'L'){
                    visited[nx][ny] = visited[now[0]][now[1]] + 1;
                    dist = Math.max(dist, visited[nx][ny]);
                    que.add(new int[] {nx, ny});
                }
            }
        }

        result = Math.max(result, dist);


    }
}
