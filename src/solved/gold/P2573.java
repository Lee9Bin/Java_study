package solved.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P2573 {

    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};

    static int N, M;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        ArrayDeque<int[]> iceMountain = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                // 빙산 저장 x, y, count
                if (map[i][j] != 0) iceMountain.add(new int[]{i, j, map[i][j]});
            }
        }
        // 입력 끝

        int result = 0;
        int time = 0;
        while (!iceMountain.isEmpty()) {

            visited = new boolean[N][M];
            int count = 0;
            for (int[] now : iceMountain) {
                int x = now[0];
                int y = now[1];
                if (!visited[x][y]) {
                    visited[x][y] = true;
                    checkCount(x, y);
                    count++;
                }
            }

            // System.out.println("count: " + count);
            if (count >= 2) {
                result = time;
                break;
            }

            time++;

            int k = iceMountain.size();
            ArrayList<int[]> zeroList = new ArrayList<>();
            // System.out.println("k: " + k);
            for (int i = 0; i < k; i++) {
                int[] now = iceMountain.pollFirst();
                int x = now[0];
                int y = now[1];

                int zeroCount = 0;
                for (int j = 0; j < 4; j++) {
                    int nextX = x + dx[j];
                    int nextY = y + dy[j];
                    if (0 <= nextX && nextX < N && 0 <= nextY && nextY < M && map[nextX][nextY] == 0) {
                        zeroCount++;
                    }
                }

                now[2] -= zeroCount;

                if (now[2] > 0) {
                    iceMountain.addLast(now);
                    map[x][y] = now[2];
                } else {
                    zeroList.add(new int[]{x, y});
                }
            }
            for (int[] zero : zeroList) {
                map[zero[0]][zero[1]] = 0;
            }

        }

        System.out.println(result);
    }

    // 몇 덩이인지 체크하는 메서드
    public static void checkCount(int x, int y) {

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (0 <= nextX && nextX < N && 0 <= nextY && nextY < M && map[nextX][nextY] != 0 && !visited[nextX][nextY]) {
                visited[nextX][nextY] = true;
                checkCount(nextX, nextY);
            }
        }
    }
}
