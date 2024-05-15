package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class P16948 {

    static final int[] dx = {-2,-2, 0,0,2,2};
    static final int[] dy = {-1, 1, -2, 2, -1, 1};
    static int n, startX, startY, endX, endY;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        startX = Integer.parseInt(st.nextToken());
        startY = Integer.parseInt(st.nextToken());
        endX = Integer.parseInt(st.nextToken());
        endY = Integer.parseInt(st.nextToken());

        bfs();

    }

    public static void bfs(){
        ArrayDeque<int[]> que = new ArrayDeque<>();

        que.add(new int[] {startX,startY});

        while (!que.isEmpty()){
            int[] now = que.pollFirst();
            int x = now[0];
            int y = now[1];
            if (x == endX && y==endY){
                System.out.println(map[x][y]);
                return;
            }

            for (int i = 0; i < 6; i++){
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                if ( 0 <= nextX && nextX < n && 0 <= nextY && nextY < n){
                    if (map[nextX][nextY] == 0){
                        map[nextX][nextY] = map[x][y] + 1;
                        que.add(new int[] {nextX, nextY});
                    }
                }
            }
        }

        System.out.println(-1);
    }
}
