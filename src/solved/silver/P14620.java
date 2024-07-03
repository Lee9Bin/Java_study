package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class P14620 {

    static final int[] dx = {0,-1, 0, 1, 0};
    static final int[] dy = {0, 0, 1, 0, -1};

    static int n, result;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[n][n];
        result = Integer.MAX_VALUE;
        makeList(0,0, 0);
        System.out.println(result);
    }

    public static void makeList(int index, int cnt, int total){
        if (total > result) return;
        if (cnt == 3){
            result = Math.min(result, total);
            return;
        }

        for (int i = index; i < n*n; i++){
            int x = i / n;
            int y = i % n;
            if (isLive(x,y)){
                //죽지 않는 꽃이다.
                //방문 처리해야한다.
                changeVisit(x, y, true);
                int nowCost = cost(x, y);
                makeList(i+1, cnt + 1, total + nowCost);
                changeVisit(x, y, false);

            }
        }

    }

    public static boolean isLive(int x, int y){
        for (int i = 0; i < 5; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= n || ny >= n || visited[nx][ny]){
                return false;
            }
        }
        return true;
    }

    public static int cost(int x, int y){
        int total = 0;
        for (int i = 0; i < 5; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            total += map[nx][ny];
        }
        return total;
    }

    public static void changeVisit(int x, int y, boolean status){
        for (int i = 0; i < 5; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            visited[nx][ny]  = status;
        }
    }
}
