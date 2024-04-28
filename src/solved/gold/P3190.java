package solved.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class P3190 {
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    static int N, K, L;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];

        StringTokenizer st;
        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = 1; //사과 1
        }

        L= Integer.parseInt(br.readLine());
        Queue<int[]> que = new ArrayDeque<>();
        for (int i = 0; i < L; i++){
            st = new StringTokenizer(br.readLine());
            int times = Integer.parseInt(st.nextToken());
            String change = st.nextToken();
            if (change.equals("D")){
                que.add(new int[] {times, 1});
            }
            else if (change.equals("L")){
                que.add(new int[] {times, -1});
            }
        }

        int dir = 0;
        int x = 1;
        int y = 1;
        map[x][y] = 2;

        int dir2 = 0;
        int endX = 1;
        int endY = 1;
        int result = 0;
        Queue<int[]> changeInfo = new ArrayDeque<>();
        while (true){
            int nextX = x + dx[dir];
            int nextY = y + dy[dir];
            if (nextX <=0 || nextY <= 0 || nextX >N || nextY >N|| map[nextX][nextY] == 2){
                break;
            }

            result ++;
            if (map[nextX][nextY] == 1){
                map[nextX][nextY] = 2;
                x = nextX;
                y = nextY;
                int[] nowInfo = que.peek();
                int times = nowInfo[0];
                int change = nowInfo[1];
                if (result == times) {
                    que.poll();
                    dir += change;
                    if (dir == 4) dir = 0;
                    else if (dir == -1) dir = 3;
                    changeInfo.add(new int[] {nextX, nextY, dir});
                }
            }

            if (map[nextX][nextY] == 0){
                map[nextX][nextY] = 2;
                x = nextX;
                y = nextY;
                if(!que.isEmpty()){
                    int[] nowInfo = que.peek();
                    int times = nowInfo[0];
                    int change = nowInfo[1];
                    if (result == times) {
                        que.poll();
                        dir += change;
                        if (dir == 4) dir = 0;
                        else if (dir == -1) dir = 3;
                        changeInfo.add(new int[] {nextX, nextY, dir});
                    }
                }
                map[endX][endY] = 0;
                endX += dx[dir2];
                endY += dy[dir2];
                System.out.println(endX + " " +endY);
                if(!changeInfo.isEmpty()){
                    int next[] = changeInfo.peek();
                    if (next[0] == endX && next[1] == endY){
                        dir2 = next[2];
                        changeInfo.poll();
                    }
                }
            }
        }
        System.out.println(++result);
    }
}
