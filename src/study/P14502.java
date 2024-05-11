package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P14502 {

    final static int[] dx = {0,0,1,-1};
    final static int[] dy = {1,-1,0,0};

    static int N, M, result;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //입력 받기 끝
        //벽치기 부터 ㄱㄱ
        result = Integer.MIN_VALUE;
        makeWall(0);
        System.out.println(result);
    }
    public static void makeWall(int cnt){
        if (cnt == 3){
            int[][] newMap = new int[N][M];
            Queue<int[]> viruses = new ArrayDeque<>();
            for (int i = 0; i < N; i++){
                for (int j = 0; j < M; j++){
                    newMap[i][j] = map[i][j];
                    if (map[i][j] == 2) viruses.add(new int[] {i,j});
                }
            }

            virus(viruses, newMap);
            return;
        }

        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if (map[i][j] == 0 && !visited[i][j]){
                    map[i][j] = 1;
                    visited[i][j] = true;
                    makeWall(cnt + 1);
                    map[i][j] = 0;
                    visited[i][j] = false;
                }
            }
        }
    }

    public static void virus(Queue<int[]> viruses, int[][] map){
        boolean[][] visited = new boolean[N][M];

        while (!viruses.isEmpty()){
            int[] now = viruses.poll();
            int x = now[0];
            int y = now[1];

            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if (0 <= nextX && nextX < N && 0 <= nextY && nextY < M && map[nextX][nextY] == 0 && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    map[nextX][nextY] = 2;
                    viruses.add(new int[] {nextX, nextY});
                }
            }
        }

        int total = 0;
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if(map[i][j] == 0) total ++;
            }
        }
        result = Math.max(result, total);
    }
}
