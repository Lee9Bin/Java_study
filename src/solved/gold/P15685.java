package solved.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P15685 {

    static int[] dx = {0,-1,0,1};
    static int[] dy = {1,0,-1,0};
    static int N, result;
    static int[][] map = new int[101][101];
    static ArrayList<ArrayList<Integer>> dList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++){ //n개 만큼
            StringTokenizer st = new StringTokenizer(br.readLine());
            dList = new ArrayList<>();
            int y = Integer.parseInt(st.nextToken()); //시작위치 y좌표
            int x = Integer.parseInt(st.nextToken()); //시작위치 x좌표
            int d = Integer.parseInt(st.nextToken()); //시작 방향
            int g = Integer.parseInt(st.nextToken()); //몇세대 인지
            dList.add(new ArrayList<>()); // 0세대 추가
            dList.get(0).add(d); // 0세대 드래곤 커브 방향 저장

            for (int j = 1; j <= g; j ++){ //이전세대 방향을 가지고 현재 세대의 방향을 만든다.
                dList.add(new ArrayList<>()); //현재 세대 추가

                for(int k = 0; k < dList.get(j-1).size(); k++){
                    dList.get(j).add(dList.get(j-1).get(k));
                }
                for(int k = dList.get(j-1).size()-1; k >=0 ; k--){
                    dList.get(j).add((dList.get(j-1).get(k)+1)%4);
                }
            }

            map[x][y] = 1;
            for(int j = 0; j < dList.get(g).size(); j ++){
                int nextX = x + dx[dList.get(g).get(j)];
                int nextY = y + dy[dList.get(g).get(j)];
                map[nextX][nextY] = 1;
                x = nextX;
                y = nextY;
            }
        }
        for(int j = 0; j < 100; j++){
            for (int k = 0; k < 100; k++){
                    if (map[j][k] == 1 && map[j+1][k] == 1 && map[j][k+1] == 1 && map[j+1][k+1] == 1){
                        result += 1;
                }
            }
        }
        System.out.println(result);
    }
}
