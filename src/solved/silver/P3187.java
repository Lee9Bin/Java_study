package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class P3187 {

    static final int[] dx = new int[]{-1, 0, 1, 0};
    static final int[] dy = new int[]{0, 1, 0, -1};

    static int R, C, K, V;
    static char[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!visited[i][j] && map[i][j] != '#') {
                    BFS(i, j);
                }
            }
        }
        System.out.println(K + " " + V);
    }

    public static void BFS(int x, int y) {
        ArrayDeque<int[]> que = new ArrayDeque<>();

        int wolf = 0;
        int sheep = 0;
        if (map[x][y] == 'v') wolf++;
        else if (map[x][y] == 'k') sheep++;

        visited[x][y] = true;
        que.add(new int[]{x, y});

        while (!que.isEmpty()) {
            int[] now = que.pollFirst();

            for (int i = 0; i < 4; i++){
                int nextX = now[0] + dx[i];
                int nextY = now[1] + dy[i];
                if (0 <= nextX && nextX < R && 0 <= nextY && nextY < C && !visited[nextX][nextY]){
                    if (map[nextX][nextY] != '#'){
                        if (map[nextX][nextY] == 'v') wolf++;
                        else if (map[nextX][nextY] == 'k') sheep++;
                        visited[nextX][nextY] = true;
                        que.add(new int[] {nextX, nextY});
                    }
                }
            }
        }
        if (sheep > wolf) K += sheep;
        else V += wolf;

    }
}
