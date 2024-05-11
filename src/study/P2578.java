package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class P2578 {
    private static int[][] graph = new int[5][5];
    private static boolean[][] visited = new boolean[5][5];
    private static int bingo = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, int[]> map = new HashMap<>();

        for (int i = 0; i<5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j<5; j++){
                int num = Integer.parseInt(st.nextToken());
                graph[i][j] = num;
                map.put(num, new int[]{i,j});
            }
        }
        int count = 0;
        for (int i = 0; i<5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j<5; j++){
                count ++;
                int num = Integer.parseInt(st.nextToken());
                int nowX = map.get(num)[0];
                int nowY = map.get(num)[1];
                visited[nowX][nowY] = true;
                checkBingo(nowX, nowY);
                if (bingo >= 3){
                    System.out.println(count);
                    return;
                }
            }
        }
    }

    private static void checkBingo(int x, int y){
        int rowCnt = 0;
        int columnCnt = 0;

        for (int i = 0; i < 5; i++) {
            if (visited[x][i]) {
                rowCnt += 1;
            }
            if (visited[i][y]) {
                columnCnt += 1;
            }
        }

        if (rowCnt == 5) {
            bingo += 1;
        }

        if (columnCnt == 5) {
            bingo += 1;
        }

        int cnt = 0;

        if (x == y) {
            for (int i = 0; i < 5; i++) {
                if (visited[i][i]) {
                    cnt += 1;
                }
            }
        }

        if (cnt == 5) {
            bingo += 1;
        }

        cnt = 0;

        if (x + y == 4) {
            for (int i = 0; i < 5; i++) {
                if (visited[4 - i][i]) {
                    cnt += 1;
                }
            }
        }

        if (cnt == 5) {
            bingo += 1;
        }
    }
}
