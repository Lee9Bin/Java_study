package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P17484 {

    static int[] dy = {-1, 0, 1};
    static int N, M, result;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        result = Integer.MAX_VALUE;
        for (int i = 0; i < M; i++) {
            dfs(0, i, map[0][i], 3);
        }

        System.out.println(result);
    }

    public static void dfs(int x, int y, int count, int preDir) {
        if (result < count) return;

        if (x == N - 1) {
            result = Math.min(result, count);
            return;
        }


        for (int i = -1; i < 2; i++) {
            if (i != preDir) {

                int nx = x + 1;
                int ny = y + i;

                if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                    dfs(nx, ny, count + map[nx][ny], i);
                }

            }
        }


    }
}
