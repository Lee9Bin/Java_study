package solved.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1520 {

    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    static int M, N;
    static int[][] map, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        dp = new int[M][N];
        for (int[] temp : dp) {
            Arrays.fill(temp, -1);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // bfs();
        System.out.println(dfs(0, 0));
    }

    public static int dfs(int x, int y) {
        if (x == M - 1 && y == N - 1) {
            return 1;
        }

        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        dp[x][y] = 0;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (checkRange(nextX, nextY) && map[x][y] > map[nextX][nextY]) {
                dp[x][y] += dfs(nextX, nextY);
            }
        }

        return dp[x][y];
    }

    public static void bfs() {

        int[][] count = new int[M][N];

        PriorityQueue<int[]> deque = new PriorityQueue<>((int[] o1, int[] o2) -> {
            return o2[2] - o1[2];
        });
        count[0][0] = 1;
        deque.add(new int[]{0, 0, map[0][0]});

        while (!deque.isEmpty()) {
            int[] now = deque.poll();


            for (int i = 0; i < 4; i++) {
                int nextX = now[0] + dx[i];
                int nextY = now[1] + dy[i];

                if (checkRange(nextX, nextY) && map[now[0]][now[1]] > map[nextX][nextY]) {
                    if (count[nextX][nextY] == 0) {
                        deque.add(new int[]{nextX, nextY, map[nextX][nextY]});
                    }
                    count[nextX][nextY] += count[now[0]][now[1]];
                }
            }
        }

        System.out.println(count[M - 1][N - 1]);
    }

    public static boolean checkRange(int x, int y) {
        return 0 <= x && x < M && 0 <= y && y < N;
    }
}
