package solved.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P16234 {

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    static int N,L,R;
    static boolean flag;
    static int[][] map; // 입력 받은 맵
    static boolean[][] visited; //방문 체크하기 위한

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()); //
        N = Integer.parseInt(st.nextToken()); // N 사이즈 맵
        map = new int[N][N];
        L = Integer.parseInt(st.nextToken()); // L명 이상
        R = Integer.parseInt(st.nextToken()); // R명 이하여야 경계가 열림 즉, 한 격자를 기준으로 사방을 갈 수 있음


        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0; // 최종 인구이동 일수
        while (true){
            visited = new boolean[N][N];
            flag = true;
            for (int i = 0; i < N; i++){
                for (int j = 0; j < N; j++){
                    if (!visited[i][j]){ // 아직 미방문
                        bfs(i, j);
                    }
                }
            }
            if (flag) break; // 모든 나라를 탐색했는데 연합이 존재 하지 않았다면 종료
            result ++;
        }
        System.out.println(result);
    }

    public static void bfs(int x, int y){
        Queue<int[]> que = new ArrayDeque<>();
        visited[x][y] = true;
        ArrayList<int[]> xyList = new ArrayList<>();
        que.add(new int[] {x,y});
        xyList.add(new int[] {x,y});
        int total = map[x][y];
        int cnt = 1;

        while (!que.isEmpty()){
            int[] now = que.poll();
            for (int i = 0; i < 4; i++){
                int nextX = now[0] + dx[i];
                int nextY = now[1] + dy[i];

                if (0 <= nextX && nextX < N && 0 <= nextY && nextY < N && !visited[nextX][nextY]){
                    if (L <= Math.abs(map[now[0]][now[1]] - map[nextX][nextY]) && Math.abs(map[now[0]][now[1]] - map[nextX][nextY]) <= R){
                        visited[nextX][nextY] = true;
                        total += map[nextX][nextY];
                        cnt += 1;
                        que.add(new int[] {nextX, nextY});
                        xyList.add(new int[] {nextX, nextY});
                    }
                }
            }
        }
        if(cnt > 1) flag = false; // 갯수가 1이상은 그날은 연합이 존재
        for(int[] xy : xyList){
            map[xy[0]][xy[1]] = total/cnt;
        }
    }
}
