package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2169 {

    static final int[] dx = {0, 1, 0};
    static final int[] dy = {-1, 0, 1};


    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        dp = new int[N][M][3];

        for (int[][] ints : dp) {
            for (int[] anInt : ints) {
                Arrays.fill(anInt, -100000);
            }
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited[0][0] = true;

        System.out.println(dfs(0, 0, 0));
    }

    public static int dfs(int x, int y, int dir) {
        if (x == N - 1 && y == M - 1) {
            return map[x][y];
        }
        if (dp[x][y][dir] != -100000) {
            return dp[x][y][dir];
        }

        for (int i = 0; i < 3; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (0 <= nextX && nextX < N && 0 <= nextY && nextY < M && !visited[nextX][nextY]) {
                visited[nextX][nextY] = true;
                dp[x][y][dir] = Math.max(dp[x][y][dir], map[x][y] + dfs(nextX, nextY, i));
                visited[nextX][nextY] = false;
            }
        }

        return dp[x][y][dir];
    }
}