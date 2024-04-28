package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class P20125 {

    static int[] dx = {0,0,1,1,1};
    static int[] dy = {-1,1,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        char[][] map = new char[n][n];

        for (int i = 0; i < n; i++){
            map[i] = br.readLine().toCharArray();
        }

        int heartX = -1;
        int heartY = -1;
        for (int i = 0; i < n; i++){
            for(int j = 0; j<n; j++){
                if (map[i][j] == '*'){
                    heartX = i+1;
                    heartY = j;
                    break;
                }
            }
            if (heartX != -1 && heartY != -1) break;
        }

        int[][] visited = new int[n][n];
        Queue<int[]> que = new ArrayDeque<>();
        visited[heartX][heartY] = 0;
        que.add(new int[] {heartX,heartY});

        while (!que.isEmpty()){
            int[] now = que.poll();

            for (int i = 0; i < 5; i++){
                int nextX = now[0] + dx[i];
                int nextY = now[1] + dy[i];
                if (0 <= nextX && nextX < n && 0 <= nextY && nextY <n && map[nextX][nextY] == '*'){
                    if(visited[nextX][nextY] == 0){
                        visited[nextX][nextY] = visited[now[0]][now[1]] + 1;
                        que.add(new int[] {nextX, nextY});
                    }
                }
            }
        }
        int[] result = new int[5];
        //왼쪽팔
        for(int i = 0; i < heartY; i++){
            if (visited[heartX][i] != 0){
                result[0] = visited[heartX][i];
                break;
            }
        }

        //오른쪽 팔
        for(int i = n-1; i > heartY; i--){
            if (visited[heartX][i] != 0){
                result[1] = visited[heartX][i];
                break;
            }
        }

        //몸길이
        for(int i = n-1; i > heartX; i--){
            if (visited[i][heartY] != 0){
                result[2] = visited[i][heartY];
                break;
            }
        }

        for(int i = n-1; i > heartX; i--){
            if (visited[i][heartY-1] != 0){
                result[3] = visited[i][heartY-1]-result[2];
                break;
            }
        }

        for(int i = n-1; i > heartX; i--){
            if (visited[i][heartY+1] != 0){
                result[4] = visited[i][heartY+1]-result[2];
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(heartX+1).append(" ").append(heartY+1).append("\n");
        for (int i = 0; i < 5; i++){
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb);
    }
}
