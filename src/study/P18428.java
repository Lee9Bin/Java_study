package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P18428 {


    final static int[] dx = {0,0,1,-1};
    final static int[] dy = {1,-1,0,0};

    static int N;
    static boolean flag;
    static ArrayList<int []> teachers;
    static String[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new String[N][N];
        teachers = new ArrayList<>();
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++){
                map[i][j] = st.nextToken();
                if (map[i][j].equals("T")) teachers.add(new int[] {i,j});
            }
        }

        //입력 받기 끝

        makeWall(0);
        if (flag) System.out.println("YES");
        else System.out.println("NO");
    }
    public static void makeWall(int cnt){
        if (flag){
            return;
        }
        if (cnt == 3){
            ArrayList<int[]> copyOfTeachers = new ArrayList<>(teachers);
            find(copyOfTeachers, map);
            return;
        }

        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                if (map[i][j].equals("X") && !visited[i][j]){
                    map[i][j] = "W";
                    visited[i][j] = true;
                    makeWall(cnt + 1);
                    map[i][j] = "X";
                    visited[i][j] = false;
                }
            }
        }
    }

    public static void find(ArrayList<int[]> teachers, String[][] map) {
        int findStudents = 0;

        for (int i = 0; i < teachers.size(); i++){
            int[] now = teachers.get(i);
            int x = now[0];
            int y = now[1];

            for (int j = 0; j < 4; j++) {

                int nextX = x + dx[j];
                int nextY = y + dy[j];

                while (true){

                    if (0 > nextX || nextX >= N || 0 > nextY || nextY >= N  || map[nextX][nextY].equals("W")) {
                        //범위 넘어가면 패스
                        break;
                    }
                    if (map[nextX][nextY].equals("S")){
                        findStudents ++;
                    }
                    nextX += dx[j];
                    nextY += dy[j];
                }
            }
        }
        if(findStudents == 0) flag = true;

    }
}
