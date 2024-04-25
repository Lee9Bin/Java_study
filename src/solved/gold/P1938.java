package solved.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class P1938 {

    static int n;
    static char[][] map;
    static boolean[][][] visited;

    static final int[] dx = { -1, 0, 1, 0 };
    static final int[] dy = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        visited = new boolean[n][n][2];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }
        bfs();
    }

    public static void getDirection(ArrayList<int[]> info){
        int[] first = info.get(0);
        int[] second = info.get(1);

        //가로 모양
        int[] direction = info.get(3);
        if (first[0] == second[0]){
            direction[0] = 0;
        }
        //세로모양
        else{
            direction[0] = 1;
        }

    }

    public static void bfs() {

        //좌표1, 좌표2, 좌표3, (방향, 횟수)
        ArrayList<int[]> info = new ArrayList<>();
        ArrayList<int[]> target = new ArrayList<>();

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if(map[i][j] == 'B') info.add(new int[] {i, j});
                else if (map[i][j] == 'E') target.add(new int[] {i, j});
            }
        }
        info.add(new int[] {0,0});

        getDirection(info);

        for (int i = 0; i < 3; i++) {
            int[] coordinate = info.get(i);
            visited[coordinate[0]][coordinate[1]][info.get(3)[0]] = true;
        }

        ArrayDeque<ArrayList<int[]>> que = new ArrayDeque<>();
        que.add(info);
        int result = Integer.MAX_VALUE;

        while (!que.isEmpty()){
            ArrayList<int[]> now = que.pollFirst();
            int direction = now.get(3)[0];
            int cnt = now.get(3)[1];
            boolean flag = true;
            for(int i = 0; i < 3; i++){
                if(!Arrays.equals(now.get(i), target.get(i))){
                    flag = false;
                }
            }

            if(flag) result = Math.min(result, cnt);

            for (int i = 0; i < 4; i++){
                ArrayList<int[]> next = new ArrayList<>();
                int visitCnt = 0;
                for (int j = 0; j < 3; j++){
                    int nextX = now.get(j)[0] + dx[i];
                    int nextY = now.get(j)[1] + dy[i];
                    if ( 0 <= nextX && nextX < n && 0 <= nextY && nextY < n && map[nextX][nextY] != '1') {
                        if (!visited[nextX][nextY][direction]){
                            visitCnt++;
                        }
                        next.add(new int[] {nextX, nextY});
                    }

                }

                if (visitCnt > 0 && next.size() == 3){
                    next.add(new int[] {0 ,cnt + 1});
                    getDirection(next);
                    changeVisited(next);
                    que.add(next);
                }
            }

            int[] first = now.get(0);
            int[] second = now.get(1);
            if (first[0] - second[0] == 0) {
                //가로로 돼있다.
                //각 좌표 위아래 확인
                ArrayList<int[]> next = new ArrayList<>();
                boolean flag2 = true;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 4; j+=2) {
                        int nextX = now.get(i)[0] + dx[j];
                        int nextY = now.get(i)[1] + dy[j];
                        if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n || map[nextX][nextY] == '1') {
                            flag2 = false;
                        }
                    }
                }
                if (flag2) {
                    if (!visited[now.get(0)[0] - 1][now.get(0)[1] + 1][1] || !visited[now.get(1)[0]][now.get(1)[1]][1]
                            || !visited[now.get(2)[0] + 1][now.get(2)[1] - 1][1]) {
                        next.add(new int[] {now.get(0)[0] -1, now.get(0)[1] + 1});
                        next.add(new int[] {now.get(1)[0] ,   now.get(1)[1] });
                        next.add(new int[] {now.get(2)[0] +1, now.get(2)[1] - 1});
                        next.add(new int[] {1, cnt + 1});
                        changeVisited(next);
                        que.add(next);
                    }
                }
            }
            else {
                //세로로 돼있다.
                //각 좌표 좌우 확인
                ArrayList<int[]> newInfo = new ArrayList<>();
                boolean flag2 = true;
                for (int i = 0; i < 3; i++) {
                    for (int j = 1; j < 4; j+=2) {
                        int nextX = now.get(i)[0] + dx[j];
                        int nextY = now.get(i)[1] + dy[j];
                        if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n || map[nextX][nextY] == '1') {
                            flag2 = false;
                        }
                    }
                }
                if (flag2) {
                    if (!visited[now.get(0)[0] + 1][now.get(0)[1] - 1][0] || !visited[now.get(1)[0]][now.get(1)[1]][0]
                            || !visited[now.get(2)[0] -1][now.get(2)[1] + 1][0]) {
                        newInfo.add(new int[] {now.get(0)[0] +1, now.get(0)[1] - 1});
                        newInfo.add(new int[] {now.get(1)[0] ,   now.get(1)[1] });
                        newInfo.add(new int[] {now.get(2)[0] -1, now.get(2)[1] + 1});
                        newInfo.add(new int[] {0, cnt+1});
                        changeVisited(newInfo);
                        que.add(newInfo);
                    }

                }
            }
        }
        if (result == Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(result);
    }

    public static void changeVisited(ArrayList<int[]> info){
        int direction = info.get(3)[0];

        for (int i = 0; i < 3; i++){
            visited[info.get(i)[0]][info.get(i)[1]][direction] = true;
        }
    }
}
