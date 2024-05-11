package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1245 {

    static int N;
    static int M;
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

        int result = 0;
        for(int i = 0; i < N; i++){
            for (int j = 0; j<M; j++){
                if (!visited[i][j] && bfs(i,j,map[i][j])){
                    result++;
                }
            }
        }
        System.out.println(result);
    }

    public static boolean bfs(int x, int y, int height){
        Queue<int[]> que = new ArrayDeque<>();
        ArrayList<int[]> same = new ArrayList<>();

        que.add(new int[] {x,y});
        same.add(new int[] {x,y});
        visited[x][y] = true;


        int[] dx = {-1,-1,-1,0,1,1,1,0};
        int[] dy = {-1,0,1,1,1,0,-1,-1};
        while (!que.isEmpty()){
            int now[] = que.poll();

            for (int i = 0; i < 8; i++){
                int nextX = now[0] + dx[i];
                int nextY = now[1] + dy[i];
                if (0 <= nextX && nextX < N && 0 <= nextY && nextY < M && map[nextX][nextY] == height &&!visited[nextX][nextY]){
                    visited[nextX][nextY] = true;
                    que.add(new int[] {nextX, nextY});
                    same.add(new int[] {nextX, nextY});
                }
            }
        }

        for (int[] s : same){
            for (int i = 0; i < 8; i++){
                int nextX = s[0] + dx[i];
                int nextY = s[1] + dy[i];
                if (0 <= nextX && nextX < N && 0 <= nextY && nextY < M){
                    if (map[nextX][nextY] > height){
                        return false;
                    }
                }
            }
        }
        return true;

    }
}
